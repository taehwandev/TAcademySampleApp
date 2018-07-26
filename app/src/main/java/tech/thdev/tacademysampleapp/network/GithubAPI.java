package tech.thdev.tacademysampleapp.network;

import tech.thdev.tacademysampleapp.contract.Contract;

public class GithubAPI {

    private GitHubRepositoriesService gitHubRepositoriesService;

    private GithubAPI() {
        gitHubRepositoriesService = RetrofitCreator.createRetrofit(Contract.API, GitHubRepositoriesService.class);
    }

    private static GithubAPI instance;

    public static GithubAPI getInstance() {
        if (instance == null) {
            synchronized (GithubAPI.class) {
                if (instance == null) {
                    instance = new GithubAPI();
                }
            }
        }
        return instance;
    }

    public GitHubRepositoriesService getGithubService() {
        return gitHubRepositoriesService;
    }
}
