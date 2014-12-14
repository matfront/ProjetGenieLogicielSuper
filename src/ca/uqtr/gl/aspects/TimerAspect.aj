package ca.uqtr.gl.aspects;

import ca.uqtr.gl.services.ArchiveTimer;
import ca.uqtr.gl.ui.EcranPrincipal;

public aspect TimerAspect {
	pointcut startEcranPrincipal(): 
		call(EcranPrincipal.new());
	
	after() : startEcranPrincipal() {
		new ArchiveTimer();
	}
}
