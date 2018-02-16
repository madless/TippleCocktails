package info.madless.tipplecocktails;

import javax.inject.Singleton;

import dagger.Component;
import info.madless.tipplecocktails.data.ApiServiceModule;
import info.madless.tipplecocktails.data.ApiService;

/**
 * 15/2/2018.
 */

@Singleton
@Component(modules = { ApiServiceModule.class })
public interface ApplicationComponent {
    ApiService getApiService();
}
