================================================================================

Decisionnaires :
  
  -- Modification de la méthode abstraite deplacer() de Decisionnaires(paramètre supplémentaire : String direction)

================================================================================

Joueur :

  -- Méthode gagner() renommée joueurGagne(Grille), changement de son code : compare directement la position du joueur avec celle
     de l'objectif, au lieu de la position suivante du joueur
  
  -- Méthode joueurPerd(Grille) ajoutée : retourne true si le joueur a perdu, false sinon

================================================================================

Random :
  
  -- Modification de la méthode deplacer() : retourne un booléen indiquant si l'Ennemi s'est déplacé et prend en paramètre une String
     (paramètre inutile, juste pour redéfinir la méthode deplacer() de Decisionnaires)
     
================================================================================
interfaceGraphique :
  
  -- Ajout de la classe GameLauncher
  
  -- GameLauncher() : ouvre une fenêtre contenant le jeu, avec possibilité de recommencer le jeu en cours de partie 
     ou après la fin de la partie
  
  -- GameLauncher(JPanel parent) : ouvre le jeu dans le JPanel passé en paramètre

================================================================================
manager :
  
  -- Ajout de la classe Manager pour gérer les données du jeu
  
================================================================================
  
Grille :
  
  -- Attributs COLONNE et LIGNE renommés TAILLE_X et TAILLE_Y, et passés en static
  
  -- Méthodes colonne() et ligne() renommées getTailleX() et getTailleY() et passées en static
  
================================================================================
