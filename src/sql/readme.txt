how to use 'my webshopDB creation script.sql'

start console
cd C:\Program Files\MySQL\MySQL Server 5.7\bin

>mysql --host=localhost --user=root --password=root

> CREATE DATABASE webshop;

> SOURCE ...(your path from 'my webshopDB creation script.sql')
for example:
> SOURCE C:\Project\InternetMagazine\src\sql\my webshopDB creation script.sql