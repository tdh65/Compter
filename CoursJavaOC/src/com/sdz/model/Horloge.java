package com.sdz.model;

import java.util.ArrayList;
import java.util.Calendar;

import com.sdz.observer.Observable;
import com.sdz.observer.Observateur;

public class Horloge implements Observable {
	// Objet calendrier pour récupérer l'heure courante
	private Calendar cal;
	private String hour = "";
	private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();

	public void run() {
		System.out.println("horloge.run");
		while (true) {
			// On récupère l'instance d'un calendrier à chaque tour
			// Elle va nous permettre de récupérer l'heure actuelle
			this.cal = Calendar.getInstance();
			this.hour = // Les heures
					this.cal.get(Calendar.HOUR_OF_DAY) + " : " + ( // Les minutes
					this.cal.get(Calendar.MINUTE) < 10 ? "0" + this.cal.get(Calendar.MINUTE)
							: this.cal.get(Calendar.MINUTE)) + " : " + ( // Les secondes
					(this.cal.get(Calendar.SECOND) < 10) ? "0" + this.cal.get(Calendar.SECOND)
							: this.cal.get(Calendar.SECOND));
			/*
			 * on avertit les observateur que le temps est mis a jour
			 */
			this.updateObservateur();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addObservateur(Observateur obs) {
		// TODO Auto-generated method stub
		this.listObservateur.add(obs);
	}

	@Override
	public void updateObservateur() {
		// TODO Auto-generated method stub
		for (Observateur obs : this.listObservateur)
			obs.update(hour);

	}

	@Override
	public void delObservateur() {
		// TODO Auto-generated method stub
		this.listObservateur = new ArrayList<Observateur>();
	}
}