

public enum Couleur {
MARRON("marron, "),
BLEU("Bleu"),
VERT("Vert"),
VERRON("verron"),
INCONNU("Non determiné"),
ROUGE("Rouge mais j 'ai une piscine .........") ;
 private  String name = "";
 Couleur (String n ){name = n ;} ;
 public String toString() {return name; }
 }