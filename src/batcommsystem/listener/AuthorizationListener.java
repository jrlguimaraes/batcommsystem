package batcommsystem.listener;

import java.util.regex.Pattern;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import batcommsystem.controller.PersonMB;

public class AuthorizationListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	private static final String RESTRICTION_PATTERN = "^/pages/protected.*";

	@Override
	public void afterPhase(PhaseEvent event) {

		FacesContext context = event.getFacesContext();
		String viewId = context.getViewRoot().getViewId();
		boolean urlProtegida = Pattern.matches(RESTRICTION_PATTERN, viewId);

		PersonMB personMB = (PersonMB) context.getExternalContext().getSessionMap().get("personMB");
		

		if (urlProtegida && personMB != null) {
	
			if (!(personMB.getUserAccountMB().getUserAccount().isAdministrator())) {
				NavigationHandler navigator = context.getApplication()
						.getNavigationHandler();
				navigator.handleNavigation(context, null, "accessDenied");
			}
		}
		if (urlProtegida && personMB == null) {
			NavigationHandler navigator = context.getApplication()
					.getNavigationHandler();
			navigator.handleNavigation(context, null, "login");
		}

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		PersonMB personMB = (PersonMB) context.getExternalContext().getSessionMap().get("personMB");
		
		if (personMB != null) {
		System.out.println("TESTE");
		System.out.println("======> " + personMB.getPerson().getName());
		System.out.println("======> " + personMB.getUserAccountMB().getUserAccount().getLogin() + "from UserAccountMB.USERACCOUNT.LOGIN");
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
