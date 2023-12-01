package edu.hw6.task5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    @Test
    void hackerNewsTopStoriesTest() {
        HackerNews hackerNews = new HackerNews();
        long[] result = hackerNews.hackerNewsTopStories();
        assertThat(result).isNotEmpty();
    }

    @Test
    void newsTest() {
        HackerNews hackerNews = new HackerNews();
        assertThat(hackerNews.news(37570037)).isEqualTo("JDK 21 Release Notes");
        assertThat(hackerNews.news(38228788)).isEqualTo("Show HN: DataSheetGrid, an Airtable-like React component");
        assertThat(hackerNews.news(38226743)).isEqualTo("Debugging tricks in the browser");
    }

}

