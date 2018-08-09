import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.zfh.binder.MyWebModule;

public class MyGuiceWebListener extends GuiceServletContextListener {
    protected Injector getInjector() {
        return Guice.createInjector(new MyWebModule());
    }
}
