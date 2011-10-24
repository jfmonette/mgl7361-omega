MGL7361 - Équipe Omega
======================

Énoncé initial du projet de session 2011-09-19 

Votre équipe doit réaliser une librairie permettant de spécifier et d'exécuter des tests unitaires (pensez à jUnit). Le design et l'implémentation de cette première version doivent accomplir les « stories » suivantes: 

- Je veux déclarer des cas de tests qui contiennent plusieurs tests individuels;
- La librairie doit fournir un mécanisme d'assertion permettant de valider si deux objets sont égaux au sens de Java (i.e. « a.equals(b) »);
- Je veux être en mesure d'exécuter tous les tests d'un cas d'un seul coup;
- Lors de l'exécution, si un des tests échoue, les autres tests doivent quand même s'exécuter;
- À la fin de l'exécution des tests, un message indique si tous les tests ont passés ou non.

Prérequis
---------

Java [JDK >= 6][jdk], [Ant][ant] et [git][git] doivent être installés.

Marche à suivre
---------------

    $ git clone git://github.com/jfmonette/mgl7361-omega.git
	$ cd mgl7361-omega
    $ ant
    $ ant run

[ant]: http://ant.apache.org/
[ivy]: http://ant.apache.org/ivy/
[git]: http://git-scm.com/
[jdk]: http://www.oracle.com/technetwork/java/javase/downloads/java-se-jdk-7-download-432154.html

