/**
 * de.htw.broker.Controller: abstract controller.
 * Copyright (c) 2013-2015 Sascha Baumeister
 */
"use strict";

this.de = this.de || {};
this.de.htw = this.de.htw || {};
this.de.htw.tournament = this.de.htw.tournament || {};
(function () {
	var SUPER = de.htw.tournament.Controller;

	/**
	 * Creates a new auctions controller that is derived from an abstract controller.
	 * @param sessionContext {de.htw.tournament.SessionContext} a session context
	 */
	de.htw.tournament.RootGameController = function (sessionContext) {
		SUPER.call(this, 2, sessionContext);
	}
	de.htw.tournament.RootGameController.prototype = Object.create(SUPER.prototype);
	de.htw.tournament.RootGameController.prototype.constructor = de.htw.tournament.ClosedAuctionsController;


	/**
	 * Displays the associated view.
	 */
	de.htw.tournament.RootGameController.prototype.display = function () {
		
	}
	
} ());