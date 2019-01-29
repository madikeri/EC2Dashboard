
function redirectToUserDetails(){
	var url = "http://"+window.location.host+"/nti/portal/userDetails";
	//var url = "http://"+window.location.host+"/portal/userDetails";
	console.log(url)							 
	window.location = url;
}

function redirectToCRMEntry(){
	var url = "http://"+window.location.host+"/nti/crm/add";
	//var url = "http://"+window.location.host+"/crm/add";
	console.log(url)							 
	window.location = url;
}

function redirectToCRMSearch(){
	var url = "http://"+window.location.host+"/nti/crm/search";
	//var url = "http://"+window.location.host+"/crm/search";
	window.location = url;
}

function redirectToCRESearch(){
	var url = "http://"+window.location.host+"/nti/cre/search";
	//var url = "http://"+window.location.host+"/cre/search";
	window.location = url;
}

function redirectToCREEntry(){
	var url = "http://"+window.location.host+"/nti/cre/customerRelationEntry";
	//var url = "http://"+window.location.host+"/cre/customerRelationEntry";
	window.location = url;
}

function redirectToNonRefundableTicket(){
	//var url = "http://"+ window.location.host+"/nti/nonrefund/nonRefundableTicket";
	var url = "http://"+ window.location.host+"/nti/nr/add";
	var url = "http://"+ window.location.host+"/nr/add";
	window.location = url;
}

function redirectToViewNonRefundableTickets(){
//	var url = "http://"+ window.location.host+"/nti/nonrefund/search";
//	var url = "http://"+ window.location.host+"/nti/nr/search";
	var url = "http://"+ window.location.host+"/nr/search";
	window.location = url;
}

/*function redirectToCurrentNR(long id){
	var url = "http://"+ window.location.host+"/nti/nonrefund/edit/{id}";
	window.location = url;
}*/

function redirectToPortal(){
	var url = "http://"+ window.location.host+"/nti/portal";
	//var url = "http://"+ window.location.host+"/portal";
	window.location = url;
}

function redirectToChangePassword(){
	var win = window.open('https://myaccount.google.com/');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToAddUser(){
	//var url = "http://"+ window.location.host+"/user/add";
	var url = "http://"+ window.location.host+"/nti/user/add";
	window.location = url;
}

function redirectToManageUsers(){
	//var url = "http://"+ window.location.host+"/user/manage";
	var url = "http://"+ window.location.host+"/nti/user/manage";
	window.location = url;
}

function redirectToCREEntry(){
	var url = "http://"+ window.location.host+"/nti/cre/add";
	
	var win = window.open(url);
	console.log(url);
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

//Links

function redirectToCallBacks(){
	var id =  $("#agentId").text();
	var url = 'http://portal.nationaltravel.com/callbacks/?id='+id;
	var win = window.open(url);
	console.log(url);
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToApprovals(){
	var url = 'http://approvals.nationaltravel.com/wp-admin';
	var win = window.open(url);
	console.log(url);
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToReportCards(){
	var url = 'http://portal.nationaltravel.com/ReportCard/RC-Search.aspx';
	var win = window.open(url);
	console.log(url);
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToFlightStats(){
	var win = window.open('https://trip.flightstats.com/login');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToFreshDesk(){
	var win = window.open('https://nationaltravel.freshdesk.com/auth/google_login');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToShoutOut(){
	var win = window.open('http://nationaltravel.com/shoutout');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToLearning(){
	var win = window.open('http://approvals.nationaltravel.com/learning');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToTimeForce(){
	var win = window.open('https://www.gotimeforce2.com/tfiiredirector');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToAIRS(){
	//var win = window.open('http://airs2008.nationaltravel.com/agentsearch/?xray=1');
	var win = window.open('http://client.nationaltravel.com/airs/agent');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToNEWAIRS(){
	var win = window.open('http://approvals.nationaltravel.com/654dgad65f4adr7ya35f1c3v21b53z4dt68ad7rt35fxvcvb/');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToOldWebPortal(){
	var win = window.open('http://www2.nationaltravel.com/2006/employee.htm');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToViewTrip(){
	var win = window.open('https://www.viewtrip.com/NATLTRAV/home.aspx');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToTravelRewardsLookup(){
	var win = window.open('http://nationaltravel.com/travel-rewards-agent');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToPurchaseOrder(){
	var win = window.open('https://docs.google.com/a/nationaltravel.com/forms/d/e/1FAIpQLScDBPxFsXmmjx7HRrC-kGLyBAKmY_bYTCY4Fi7vy1ICS1G7sw/viewform');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToGiftCards(){
	var win = window.open('http://www.citytraxonline.com/giftcard/');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToSubmitITTicket(){
	var win = window.open('http://nationaltravel.freshdesk.com/helpdesk/tickets/new');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToEndStore(){
	var win = window.open('https://business.landsend.com/store/nti/');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}

function redirectToEmployeePortal(){
	var win = window.open('http://portal.nationaltravel.com/employeeguidelines/');
	if (win) {
		win.focus();
	} else {
		//Browser has blocked it
		alert('Please allow popups for this website');
	}
}





$(document).ready(function() {
	$('.dropdown-submenu a.test').on("click", function(e) {
		$(this).next('ul').toggle();
		e.stopPropagation();
		e.preventDefault();
	});

	$('.dropdown-submenu a.helpdropdown').on("click", function(e) {
		$(this).next('ul').toggle();
		e.stopPropagation();
		e.preventDefault();
	});
});

function toggleSide(){
	console.log("toggle");
	$("#wrapper").toggleClass("active");
	$("#pagewrapper").toggleClass("active");
};
