package pages.authpages.upgrades;

import database.Actions;
import pages.CurrentUser;

public final class BuyPremium {
    /**
     *
     * @param actions
     */
    public void buyPremium(final Actions actions) {
        new CurrentUser().getCurrentUser().setTokensCount(new CurrentUser()
                .getCurrentUser().getTokensCount() - 10);
        new CurrentUser().getCurrentUser().getCredentials().setAccountType("premium");
    }
}
