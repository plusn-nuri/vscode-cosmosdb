/*---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

export function getDatabaseNameFromConnectionString(connectionString: string): string | undefined {
    //  Connection strings follow the following format (https://docs.mongodb.com/manual/reference/connection-string/):
    // mongodb://[username:password@]host1[:port1][,host2[:port2],...[,hostN[:portN]]][/[database][?options]]
    // Some example connection strings:
    //   mongodb://dbuser:dbpassword@dbname.mlab.com:14118/dbname
    //   mongodb://db1.example.net:27017,db2.example.net:2500/?replicaSet=test
    //   mongodb://router1.example.com:27017,router2.example2.com:27017,router3.example3.com:27017/

    try {
        let matches = connectionString.match(/[a-zA-Z]+:\/\/[^/]+(\/([^/?]+))/);
        if (matches) {
            let [, , database] = matches;
            return database;
        }
    } catch (error) {
        // Shouldn't happen, but ignore if does
    }

    return undefined;
}
