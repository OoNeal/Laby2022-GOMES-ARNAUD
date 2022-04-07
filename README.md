# <center> GOMES-ODENT & ARNAUD

## __Difficultés rencontrées__

1. La compréhension du TP en générale, la difficulté 
pas énorme cependant comprendre en sa globalité ce qui était
demandé l'était.

## __Choix de programmation__

Pour la méthode `deplacerPerso()` : le personnage se 
déplace de case en case jusqu'à arriver ce que sa prochaine
position soit un mur. 

Pour le `MainLaby` : On charge est vérifie d'abord si 
le labyrinthe est valide. Si c'est le cas, on demande 
l'action à l'utilisateur. Si l'action est valide, 
on déplace ou quitte le jeu. Sinon on redemande une action valide .

## __Comment lancer notre application__

Pour lancer notre application, il suffit de mettre le chemin vers le fichier
quand on vous invite à le faire.

## __Résultat des tests__

La totalité de nos tests sont fonctionnels.

## __Couverture de test et explications__

### __Classe Positon__
Tout d'abord, on vérifie que toutes méthodes de la classe 
`Position` fonctionne correctement. Il n'est donc pas 
nécessaire de tester `Personnage` et `Sortie`.
Soit deux tests : 
1. Le premier qui créer une position
2. Le second qui la modifie cette position.
### __Classe Labyrinthe__

#### __chargerLaby()__
1. Etant déjà tester dans `TestLabyProf`, nous récupérons 
le test pour la méthode `chargerLaby()`
2. Nous ajoutons un test pour `chargerLaby()` pour voir si 
des exceptions sont levées.

####__getChar()__
Etant utiliser dans les tests de `chargerLaby(`, il ne 
nous a pas semblé nécessaire de faire de test sur cette 
classe.

####__getSuivant()__
1. Nous testons une seule fois cette méthode, dans toutes les 
directions possibles.

####__deplacerPerso()__
1. Le premier test ne fait que déplacer le personnage vers 
le haut. Simplement pour savoir s'il va jusqu'au mur ou non.
2. Le second test aurait pu être fait dans getSuivant() et
vérifie qu'une exception de type `ActionInconnue` est levée 
lorsque l'utilisateur rentre une action incorrecte.
3. Le troisième test vérifie que le personnage ne peut pas
prendre la sortie alors qu'il n'est pas contre un mur.

####__etreFini()__
Ce test vérifie que le labyrinthe est fini 
quand le personnage atteint la sortie en étant contre un mur.







