package pages.authpages.seedetails;

import database.Output;
import database.TempOutput;
import lombok.Getter;
import lombok.Setter;
import pages.CurrentUser;


@Setter
@Getter
public final class Purchase {
    /**
     *
     */
    public void purchase() {
        if (!new CurrentUser().getCurrentUser().getPurchasedMovies()
                .contains(new SeeDetails().getViewMovie())) {
            if (new CurrentUser().getCurrentUser().getCredentials().getAccountType()
                    .equals("premium")) {
                if (new CurrentUser().getCurrentUser().getNumFreePremiumMovies() > 0) {
                    new CurrentUser().getCurrentUser().setNumFreePremiumMovies(
                            new CurrentUser().getCurrentUser().getNumFreePremiumMovies() - 1);
                } else {
                    new CurrentUser().getCurrentUser().setTokensCount(
                            new CurrentUser().getCurrentUser().getTokensCount() - 2);
                }
            } else {
                new CurrentUser().getCurrentUser().setTokensCount(
                        new CurrentUser().getCurrentUser().getTokensCount() - 2);
            }
            new CurrentUser().getCurrentUser().addPurchasedMovies(new SeeDetails().getViewMovie());
            new OneMovieOut().oneMovieOut();
        } else {
            TempOutput tempOutput = new TempOutput();
            tempOutput.addObjectNode(new Output().getOutputError());
        }
    }
}
