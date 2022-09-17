__[see [glossary](https://github.com/omismone/strapizzami/wiki/Glossario)]__  

# Thoth instructions

## Setup database

1. Install mysql-server.
1. Run the script thoth.sql (same directory of this file) as root.
1. The script will create the db.
1. Create a user named hermes and set to him a password of your choice.
1. Make sure mysql-server is running.
1. You need to see the other README file in _{project folder}/hermes/src/../services/dao/rdb_ folder, there you have to rewrite the password you have chosen.

_Note_: to run a file on cmd mysql do:  `mysql> source file.sql;`  

_Note2_: to create a user on mysql do:
 
1. _CREATE USER 'hermes'@'localhost' IDENTIFIED BY 'yourPassword';_  
1. _GRANT SELECT, INSERT, DELETE, UPDATE ON thoth.* TO 'hermes'@'localhost' WITH GRANT OPTION;_  

_Note3_: __convention adopted__ -> € > 100 on ingrediente.PREZZO means NULL! java and mysql treat NULL like 0, hence this convention..  
