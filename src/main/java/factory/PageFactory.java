package factory;

import pages.AboutUsPage;
import pages.CatalogPage;
import pages.CreateAccountPage;
import pages.ForgetPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;
import pages.SearchBar;

public class PageFactory {
	 static ThreadLocal<LoginPage> LoginPageTL = new ThreadLocal<LoginPage>();
	    static ThreadLocal<CreateAccountPage> CreateAccountTL = new ThreadLocal<CreateAccountPage>();
	    static ThreadLocal<HomePage> HomePageTL = new ThreadLocal<HomePage>();
	    static ThreadLocal<ForgetPasswordPage> ForgetPasswordPageTL = new ThreadLocal<ForgetPasswordPage>();
	    static ThreadLocal<SearchBar> SearchBarTL = new ThreadLocal<SearchBar>();
	    static ThreadLocal<AboutUsPage> AboutUsPageTL = new ThreadLocal<AboutUsPage>();
	    static ThreadLocal<ProductDetailPage> ProductDetailPageTL = new ThreadLocal<ProductDetailPage>();
	    static ThreadLocal<CatalogPage> CatalogPageTL = new ThreadLocal<CatalogPage>();
	    
	    public static LoginPage getLoginPage() {
	        if(LoginPageTL.get()==null) {
	            LoginPageTL.set(new LoginPage());
	        }
	        return LoginPageTL.get();
	    }

	    public static ForgetPasswordPage getForgetPasswordPage() {
	        if(ForgetPasswordPageTL.get()==null) {
	        	ForgetPasswordPageTL.set(new ForgetPasswordPage());
	        }
	        return ForgetPasswordPageTL.get();
	    }
	    public static CreateAccountPage getCreateAccountPage() {
	        if(CreateAccountTL.get()==null) {
	            CreateAccountTL.set(new CreateAccountPage());
	        }
	        return CreateAccountTL.get();
	    }
	    public static HomePage getHomePage() {
	        if(HomePageTL.get()==null) {
	            HomePageTL.set(new HomePage());
	        }
	        return HomePageTL.get();
	    }
	    public static SearchBar getSearchBar() {
	    	if(SearchBarTL.get()==null) {
	    		SearchBarTL.set(new SearchBar());
	    	}
	    	return SearchBarTL.get();
	    }
	    
	    public static AboutUsPage getAboutUsPage() {
	    	if(AboutUsPageTL.get()==null) {
	    		AboutUsPageTL.set(new AboutUsPage());
	    	}
	    	return AboutUsPageTL.get();
	    }
	    
	    public static ProductDetailPage getProductDetailPage() {
	    	if(ProductDetailPageTL.get()==null) {
	    		ProductDetailPageTL.set(new ProductDetailPage());
	    	}
	    	return ProductDetailPageTL.get();
	    }
	    
	    public static CatalogPage getCatalogPage() {
	    	if(CatalogPageTL.get()==null) {
	    		CatalogPageTL.set(new CatalogPage());
	    	}
	    	return CatalogPageTL.get();
	    }

}
