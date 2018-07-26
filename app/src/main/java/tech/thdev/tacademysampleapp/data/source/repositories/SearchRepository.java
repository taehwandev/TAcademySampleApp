package tech.thdev.tacademysampleapp.data.source.repositories;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import tech.thdev.tacademysampleapp.data.Repositories;
import tech.thdev.tacademysampleapp.data.RepositoriesItem;
import tech.thdev.tacademysampleapp.network.GitHubRepositoriesService;

public class SearchRepository {

    private final GitHubRepositoriesService gitHubRepositoriesService;
    private static SearchRepository instance;

    private SearchRepository(@NotNull GitHubRepositoriesService gitHubRepositoriesService) {
        this.gitHubRepositoriesService = gitHubRepositoriesService;
    }

    public static SearchRepository getInstance(@NotNull GitHubRepositoriesService gitHubRepositoriesService) {
        if (instance == null) {
            synchronized (SearchRepository.class) {
                if (instance == null) {
                    instance = new SearchRepository(gitHubRepositoriesService);
                }
            }
        }
        return instance;
    }

    private int nowPage = 1;

    public Single<List<RepositoriesItem>> searchRepositories(String searchKeyword, String sort, String order, int perPage) {
        return gitHubRepositoriesService.searchUser(searchKeyword, sort, order, nowPage, perPage)
                .map(new Function<Repositories, List<RepositoriesItem>>() {
                    @Override
                    public List<RepositoriesItem> apply(Repositories repositories) throws Exception {
                        return repositories.getItems();
                    }
                });
    }
}
