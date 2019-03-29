/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etat;

/**
 *
 * @author TTurq
 */
public enum Etat {

  /**
  * Case sur laquelle se trouve le joueur
  */
  Joueur,

  /**
  * Case sur laquelle se trouve l'ennemi
  */
  Ennemi,

  /**
  * Case sur laquelle se trouve l'objectif
  */
  Objectif,

  /**
  * Case sans ennemi, joueur, objectif ni pi&egrave;ge
  */
  CaseLibre,

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
