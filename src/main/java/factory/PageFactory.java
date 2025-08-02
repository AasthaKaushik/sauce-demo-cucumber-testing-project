package factory;

import pages.BlogsPage;
import pages.LoginPage;

public class PageFactory {
	static ThreadLocal<LoginPage> LoginPageTL = new ThreadLocal<LoginPage>();
	static ThreadLocal<BlogsPage> BlogsPageTL = new ThreadLocal<BlogsPage>();

	public static LoginPage getLoginPage() {
		if (LoginPageTL.get() == null) {
			LoginPageTL.set(new LoginPage());
		}
		return LoginPageTL.get();
	}


	public static BlogsPage getBlogsPage() {
		if (BlogsPageTL.get() == null) {
			BlogsPageTL.set(new BlogsPage());
		}
		return BlogsPageTL.get();
	}
}
