package pages.authpages.upgrades;

import database.Actions;
import pages.CurrentUser;

public final class BuyTokens {
    /**
     *
     * @param actions
     */
    public void buyTokens(final Actions actions) {
        new CurrentUser().getCurrentUser().setTokensCount(new CurrentUser()
                .getCurrentUser().getTokensCount() + actions.getCount());
        new CurrentUser().getCurrentUser().getCredentials().setBalance(Integer
                .toString(Integer.parseInt(new CurrentUser().getCurrentUser()
                        .getCredentials().getBalance()) - actions.getCount()));
    }
}
