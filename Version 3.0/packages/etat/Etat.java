package packages.etat;

/**
 * Enumeration the all state
 * @author Theo gerfaux && Johan Turquin
 * version 3.0
 */

public enum Etat {

  /**
  * Case sur laquelle se trouve le joueur
  */
  Player,

  /**
  * Case sur laquelle se trouve l'ennemi
  */
  Ennemi,

  /**
  * Case sur laquelle se trouve l'objectif
  */
  Goal,

  /**
  * Case sans ennemi, joueur, objectif ni pi&egrave;ge
  */
  FreeBox,

  /**
  * Case sur laquelle se trouve un pi&egrave;ge non d&eacute;tect&eacute; par le d&eacute;tecteur de pi&egrave;ges
  */
  PiegeNonDetecte,

  /**
  * Case sur laquelle se trouve un pi&egrave;ge d&eacute;tect&eacute; par le d&eacute;tecteur de pi&egrave;ges
  */
  VraiPiegeDetecte,

  /**
  * Case sur laquelle se trouve un faux pi&egrave;ge d&eacute;tect&eacute; par le d&eacute;tecteur de pi&egrave;ges
  */
  FauxPiegeDetecte;

}
