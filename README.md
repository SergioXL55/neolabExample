This is test project for Neolab by Ushakov Sergey.

This project find animals by serach rule.

Description of incoming data:

The programm has two incoming files:
1) animals
2) rules

remark: the path to these files could be changed in "application.properties" file.

The structure of "Animals":
The properties of one animal must be written on one line with a separated character(;).
If animal has EMPTY property then this property must be written as SPACES or EMPRTY string.
For example:
ТЯЖЕЛОЕ;НЕВЫСОКОЕ;ТРАВОЯДНОЕ
ТЯЖЕЛОЕ; ;ТРАВОЯДНОЕ

The structure of "Rules":
The properties of one animal must be written on one line with a separated character(;).
If rule has EMPTY property then this property must be written as SPACES or EMPRTY string.
The rule may has multiple rules in one rule. This must be written with a separated character(,)
For example:
ЛЕГКОЕ;НЕВЫСОКОЕ;ВСЕЯДНОЕ
 ;МАЛЕНЬКОЕ;ТРАВОЯДНОЕ,ПЛОТОЯДНОЕ
 
 
Important rule:The number of animals is increases only when the number of rules and animal properties is match.

The incoming data matches previously issued task.

