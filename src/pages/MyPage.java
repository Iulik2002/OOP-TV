package pages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class MyPage {

    private static CurrentPage myPage;

    /**
     *
     * @return
     */
    public CurrentPage getMyPage() {
        return myPage;
    }

    /**
     *
     * @param myPage
     */
    public void setMyPage(final CurrentPage myPage) {
        MyPage.myPage = myPage;
    }
}
