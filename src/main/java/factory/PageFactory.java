package factory;

import pages.BlogsPage;
import pages.navigateToCatalogPage;


public class PageFactory {
	//static ThreadLocal<LoginPage> LoginPageTL = new ThreadLocal<LoginPage>();
	static ThreadLocal<BlogsPage> BlogsPageTL = new ThreadLocal<BlogsPage>();
	static ThreadLocal<navigateToCatalogPage> CatalogPageTL = new ThreadLocal<navigateToCatalogPage>();

	

	public static BlogsPage getBlogsPage() {
		if (BlogsPageTL.get() == null) {
			BlogsPageTL.set(new BlogsPage());
		}
		return BlogsPageTL.get();
	}

	public static navigateToCatalogPage getCatalogPage() {
		if (CatalogPageTL.get() == null) {
			CatalogPageTL.set(new navigateToCatalogPage());
		}
		return CatalogPageTL.get();

	}
}
