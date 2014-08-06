/*
 * File: 	UF.java 
 * Purpose: Brings the implementation of a enumeration to support
 * the development.
 */
package br.com.visualize.akan.domain.enumeration;


/**
 * This enumeration serves to support the development. Through this enumeration 
 * is possible to easily identify the federal units present in Brazil.
 */
public enum UF {
	WHIOUT_UF, // Represent the lack of a set federal unit.
	
	/* Northern Region. */
	AC, AM, RR, RO, AP, PA,
	
	/* Northeast Region. */
	MA, PI, CE, RN, PB, PE, AL, SE, BA,
	
	/* Southeast Region. */
	ES, RJ, SP, MG,
	
	/* Southern Region. */
	PR, SC, RS,
	
	/* Midwest Region. */
	MT, MS, TO, GO, DF;
	
	/**
	 * Does the description of the state-related acronym.
	 * 
	 * @return String The name of the State related to the acronym in question.
	 */
	public String getDescriptionUf() {
		String description = "";
		
		switch( this ) {
			case AC:
				description = "Acre";
				break;
			
			case AM:
				description = "Amazonas";
				break;
			
			case RR:
				description = "Roraima";
				break;
			
			case RO:
				description = "Rond�nia";
				break;
			
			case AP:
				description = "Amapa";
				break;
			
			case PA:
				description = "Par�";
				break;
			
			case MA:
				description = "Maranh�o";
				break;
			
			case PI:
				description = "Piau�";
				break;
			
			case CE:
				description = "Cear�";
				break;
			
			case RN:
				description = "Rio Grande do Norte";
				break;
			
			case PB:
				description = "Para�ba";
				break;
			
			case PE:
				description = "Pernambuco";
				break;
			
			case AL:
				description = "Alagoas";
				break;
			
			case SE:
				description = "Sergipe";
				break;
			
			case BA:
				description = "Bahia";
				break;
			
			case ES:
				description = "Esp�rito Santo";
				break;
			
			case RJ:
				description = "Rio de Janeiro";
				break;
			
			case SP:
				description = "S�o Paulo";
				break;
			
			case MG:
				description = "Minas Gerais";
				break;
			
			case PR:
				description = "Paran�";
				break;
			
			case SC:
				description = "Santa Catarina";
				break;
			
			case RS:
				description = "Rio Grande do Sul";
				break;
			
			case MT:
				description = "Mato Grosso";
				break;
			
			case MS:
				description = "Mato Grosso do Sul";
				break;
			
			case TO:
				description = "Tocantis";
				break;
			
			case GO:
				description = "Goi�s";
				break;
			
			case DF:
				description = "Distrito Federal";
				break;
			
			default:
				description = "";
		}
		
		return description;
	}
}
