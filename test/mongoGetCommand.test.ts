/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

// The module 'assert' provides assertion methods from node
import * as assert from 'assert';
import { Position } from 'vscode';
import { getCommandFromText } from '../src/mongo/MongoScrapbook';

function testParse(text: string, expected: { collection: string, name: string, args: any[] }, errors?: { firstErrorText?: string }) {
    function testCore(text) {
        let command = getCommandFromText(text, new Position(0, 0));

        assert.equal(command.collection, expected.collection, "Parsed collection name is not correct");
        assert.equal(command.name, expected.name, "Parsed command name is not correct");

        let actualArgs = (command.arguments || []).map(arg => JSON.parse(arg));
        assert.deepEqual(actualArgs, expected.args, "Parsed arguments are not correct");

        if (errors && errors.firstErrorText) {
            assert.equal((command.errors || []).length > 0, true, "Expected at least one error");
            assert.equal(command.errors[0].message, errors.firstErrorText, "First error text was incorrect")
        } else {
            assert.equal((command.errors || []).length, 0, "Expected no errors");
        }
    }

    testCore(text);

    // Test again with LF changed to CR/LF
    let crlfText = text.replace(/\n/g, '\r\n');
    testCore(crlfText);

    // Test again with LF changed to multiple CR/LF
    let crlf2Text = text.replace(/\n/g, '\r\n\r\n');
    testCore(crlf2Text);

    // Test again with LF changed to CR
    let lfText = text.replace(/\n/g, '\r');
    testCore(lfText);

    // Test again with LF changed to tab
    let tabText = text.replace(/\n/g, '\t');
    testCore(tabText);

    // Test again with LF changed to space
    let spaceText = text.replace(/\n/g, ' ');
    testCore(spaceText);
}

suite("scrapbook parsing Tests", () => {
    test("find", () => {
        let text = "db.find()";
        let command = getCommandFromText(text, new Position(0, 0));
        assert.equal(command.text, text);
    });

    test("find with semicolon", () => {
        let text = "db.find();";
        let command = getCommandFromText(text, new Position(0, 0));
        assert.equal(command.text, text);
    });

    test("first of two commands, Mac/Linux", () => {
        let line1 = "db.find()";
        let line2 = "db.insertOne({'a': 'b'})";
        let text = `${line1}\n${line2}`;
        let command = getCommandFromText(text, new Position(0, 0));
        assert.equal(command.text, line1);
    });

    test("second of two commands, Mac/Linux", () => {
        let line1 = "db.find()";
        let line2 = "db.insertOne({'a':'b'})";
        let text = `${line1}\n${line2}`;
        let command = getCommandFromText(text, new Position(2, 0));
        assert.equal(command.text, line2);
    });

    test("second of two commands, Mac/Linux, semicolon", () => {
        let line1 = "db.find();";
        let line2 = "db.insertOne({'a':'b'})";
        let text = `${line1}\n${line2}`;
        let command = getCommandFromText(text, new Position(2, 0));
        assert.equal(command.text, line2);
    });

    test("first of two commands, Windows", () => {
        let line1 = "db.find()";
        let line2 = "db.insertOne({'a': 'b'})";
        let text = `${line1}\r\n${line2}`;
        let command = getCommandFromText(text, new Position(0, 0));
        assert.equal(command.text, line1);
    });

    test("second of two commands, Windows", () => {
        let line1 = "db.find()";
        let line2 = "db.insertOne({'a':'b'})";
        let text = `${line1}\r\n${line2}`;
        let command = getCommandFromText(text, new Position(2, 0));
        assert.equal(command.text, line2);
    });

    test("second of two commands, lots of blank lines, Windows", () => {
        let line1 = "db.find()";
        let line2 = "db.insertOne({'a':'b'})";
        let text = `\r\n\r\n\r\n\r\n\r\n\r\n${line1}\r\n\r\n\r\n\r\n\r\n\r\n${line2}\r\n\r\n\r\n\r\n\r\n\r\n`;
        let command = getCommandFromText(text, new Position(5, 0));
        assert.equal(command.text, line2);
    });

    test("first of two commands, Windows, on blank line before second command", () => {
        let line1 = "db.find()";
        let line2 = "db.insertOne({'a': 'b'})";
        let text = `${line1}\r\n\r\n\r\n${line2}`;
        let command = getCommandFromText(text, new Position(2, 0));
        assert.equal(command.text, line1);
    });

    test("drop", () => {
        testParse(
            `db.test.drop()`,
            { collection: "test", name: "drop", args: [] });
    });

    test("find, with empty object argument", () => {
        testParse(
            `db.test.find({})`,
            { collection: "test", name: "find", args: [{}] });
    });

    test("end-of-line comment", () => {
        testParse(
            `db.test.drop() // Ignore error "ns not found", it means "test" does not exist yet`,
            { collection: "test", name: "drop", args: [] });
    });

    test("multi-line insert from #214", () => {
        testParse(
            `db.heroes.insert({\n"id": 2,\r\n"name": "Batman",\r\n\r\n"saying": "I'm Batman"\r})`,
            {
                collection: "heroes", name: "insert", args: [
                    {
                        id: 2,
                        name: "Batman",
                        saying: "I'm Batman"
                    }
                ]
            });
    });

    test("find/project from #214", () => {
        testParse(
            `db.heroes.find({ "id": 2 }, { "saying": 1 })`,
            {
                collection: "heroes", name: "find", args: [
                    {
                        id: 2
                    },
                    {
                        saying: 1
                    }
                ]
            });
    });

    test("expect error: missing comma in arguments", () => {
        testParse(
            `db.heroes.find({ "id": 2 } { "saying": 1 })`,
            {
                collection: "heroes", name: "find", args: [
                    {
                        id: 2
                    }
                ]
            },
            {
                firstErrorText: "{"
            }
        );
    });

    test("expect error: missing function name", () => {
        // From https://github.com/Microsoft/vscode-cosmosdb/issues/659
        testParse(
            `db.c1.`,
            {
                collection: "c1",
                name: "",
                args: []
            },
            {
                // There should be errors, but that's covered by https://github.com/Microsoft/vscode-cosmosdb/issues/653
            }
        );

        testParse(
            `db.c1.;`,
            {
                collection: "c1",
                name: "",
                args: []
            },
            {
                // There should be errors, but that's covered by https://github.com/Microsoft/vscode-cosmosdb/issues/653
            }
        );

        testParse(
            `db.c1.(1, "a");`,
            {
                collection: "c1",
                name: "<missing STRING_LITERAL>",
                args: [
                    1,
                    'a'
                ]
            },
            {
                firstErrorText: "<missing STRING_LITERAL>"
            }
        );

        // Just make sure doesn't throw
        getCommandFromText(`db..(1, "a");`);
        getCommandFromText(`..(1, "a");`);
        getCommandFromText(`..c1(1, "a");`);
    });

    // https://github.com/Microsoft/vscode-cosmosdb/issues/467
    // test("single quoted property names", () => {
    //     testParse(
    //         `db.heroes.find({ 'id': 2 }, { 'saying': 1 })`,
    //         {
    //             collection: "heroes", name: "find", args: [
    //                 {
    //                     id: 2
    //                 },
    //                 {
    //                     saying: 1
    //                 }
    //             ]
    //         });
    // });

    // https://github.com/Microsoft/vscode-cosmosdb/issues/466
    // test("Unquoted property names", () => {
    //     testParse(
    //         `db.heroes.find({ id: 2 }, { saying: 1 })`,
    //         {
    //             collection: "heroes", name: "find", args: [
    //                 {
    //                     id: 2
    //                 },
    //                 {
    //                     saying: 1
    //                 }
    //             ]
    //         });
    // });


    test("multi-line insert from #214", () => {
        testParse(
            `db.heroes.insert({\n"id": 2,\r\n"name": "Batman",\r\n\r\n"saying": "I'm Batman"\r})`,
            {
                collection: "heroes", name: "insert", args: [
                    {
                        id: 2,
                        name: "Batman",
                        saying: "I'm Batman"
                    }
                ]
            });
    });

    test("Array followed by } on separate line, from #73", () => {
        testParse(
            `db.createUser({
                "user": "buddhi",
                "pwd": "123",
                "roles": ["readWrite", "dbAdmin"]
                }
            )`,
            {
                collection: undefined,
                name: "createUser",
                args: [
                    {
                        user: "buddhi",
                        pwd: "123",
                        roles: ["readWrite", "dbAdmin"]
                    }
                ]
            });
    });

    test("Multiple line arrays, from #489", () => {
        testParse(`
            db.c2.insertMany([
                {"name": "Stephen", "age": 38, "male": true},
                {"name": "Stephen", "age": 38, "male": true}
                ])
            `,
            {
                collection: "c2",
                name: "insertMany",
                args: [
                    [
                        {
                            name: "Stephen",
                            age: 38,
                            male: true
                        },
                        {
                            name: "Stephen",
                            age: 38,
                            male: true
                        }
                    ]
                ]
            });
    });

    test("test function call that has 2 arguments", () => {
        let arg0 = `{"Age": 31}`;
        let arg1 = `{"Name": true}`;
        let text = `db.find(${arg0}\r\n,\r\n\r\n${arg1})`;
        let command = getCommandFromText(text, new Position(0, 0));
        assert.deepEqual(JSON.parse(command.arguments![0]), JSON.parse(arg0));
        assert.deepEqual(JSON.parse(command.arguments![1]), JSON.parse(arg1));
    });
    test("test function call with nested parameters - documents in an array", () => {
        let arg0 = `[{"name": "a"}, {"name": "b"}, {"name": "c"}]`;
        let arg1 = `{"ordered": true}`;
        let text = `db.test1.insertMany(${arg0},\r\n\r\n\r\n${arg1})`;
        let command = getCommandFromText(text, new Position(0, 0));
        assert.deepEqual(JSON.parse(command.arguments![0]), JSON.parse(arg0));
        assert.deepEqual(JSON.parse(command.arguments![1]), JSON.parse(arg1));
    });
    test("test function call that has a nested parameter", () => {
        let arg0 = `{"name": {"First" : "a", "Last":"b"} }`;
        let text = `db.test1.insertMany(${arg0})`;
        let command = getCommandFromText(text, new Position(0, 0));
        assert.deepEqual(JSON.parse(command.arguments![0]), JSON.parse(arg0));
    });
    test("test function call with erroneous syntax: missing comma", () => {
        let arg0 = `{"name": {"First" : "a", "Last":"b"} }`;
        let arg1 = `{"ordered": true}`;
        let text = `db.test1.insertMany(${arg0}   ${arg1})`;
        let command = getCommandFromText(text, new Position(0, 0));
        const err = command.errors[0];
        assert.deepEqual(err.message, "{");
        assert.deepEqual(err.range.start.line, 0);
        assert.deepEqual(err.range.start.character, 61);
    });
    test("test function call with erroneous syntax: missing comma, parameters separated with newline", () => {
        let arg0 = `{"name": {"First" : "a", "Last":"b"} }`;
        let arg1 = `{"ordered": \ntrue}`;
        let text = `db.test1.insertMany(${arg0} \n  ${arg1})`;
        let command = getCommandFromText(text, new Position(0, 0));
        const err = command.errors[0];
        assert.deepEqual(err.message, "{");
        assert.deepEqual(err.range.start.line, 1);
        assert.deepEqual(err.range.start.character, 2);
    });
    test("test function call with erroneous syntax: missing double quote", () => {
        let arg0 = `{name": {"First" : "a", "Last":"b"} }`;
        let text = `db.test1.insertMany(${arg0})`;
        let command = getCommandFromText(text, new Position(0, 0));
        const err = command.errors[0];
        assert.deepEqual(err.message, "name");
        assert.deepEqual(err.range.start.line, 0);
        assert.deepEqual(err.range.start.character, 21);
    });
    test("test function call with erroneous syntax: missing opening brace", () => {
        let arg0 = `"name": {"First" : "a", "Last":"b"} }`;
        let text = `db.test1.insertMany(${arg0})`;
        let command = getCommandFromText(text, new Position(0, 0));
        const err = command.errors[0];
        assert.deepEqual(err.message, ":");
        assert.deepEqual(err.range.start.line, 0);
        assert.deepEqual(err.range.start.character, 26);
    });
});
