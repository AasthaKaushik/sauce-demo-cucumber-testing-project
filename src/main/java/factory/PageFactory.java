package factory;

import pages.*;

public class PageFactory {
	static ThreadLocal<LoginPage> LoginPageTL = new ThreadLocal<LoginPage>();
	static ThreadLocal<CreateAccountPage> CreateAccountTL = new ThreadLocal<CreateAccountPage>();
	static ThreadLocal<HomePage> HomePageTL = new ThreadLocal<HomePage>();
	static ThreadLocal<ForgetPasswordPage> ForgetPasswordPageTL = new ThreadLocal<ForgetPasswordPage>();
	static ThreadLocal<FooterPage> FooterPageTL = new ThreadLocal<FooterPage>();
	static ThreadLocal<BlogsPage> BlogsPageTL = new ThreadLocal<BlogsPage>();

	public static LoginPage getLoginPage() {
		if (LoginPageTL.get() == null) {
			LoginPageTL.set(new LoginPage());
		}
		return LoginPageTL.get();
	}

	public static ForgetPasswordPage getForgetPasswordPage() {
		if (ForgetPasswordPageTL.get() == null) {
			ForgetPasswordPageTL.set(new ForgetPasswordPage());
		}
		return ForgetPasswordPageTL.get();
	}

	public static CreateAccountPage getCreateAccountPage() {
		if (CreateAccountTL.get() == null) {
			CreateAccountTL.set(new CreateAccountPage());
		}
		return CreateAccountTL.get();
	}

	public static HomePage getHomePage() {
		if (HomePageTL.get() == null) {
			HomePageTL.set(new HomePage());
		}
		return HomePageTL.get();
	}

	public static FooterPage getFooterPage() {
		if (FooterPageTL.get() == null) {
			FooterPageTL.set(new FooterPage());
		}
		return FooterPageTL.get();
	}

	public static BlogsPage getBlogsPage() {
		if (BlogsPageTL.get() == null) {
			BlogsPageTL.set(new BlogsPage());
		}
		return BlogsPageTL.get();
	}
}
