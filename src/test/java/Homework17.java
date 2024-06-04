import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"TestPro Playlist.\"";

        //navigate to Page
        navigateToPage();
        //login
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();
        //search song
        searchSong("dark");
        Thread.sleep(1000);
        //click view all button
        clickViewAllBtn();
        Thread.sleep(1000);
        //select first song from results
        selectFirstSong();
        Thread.sleep(1000);
        //click Add to Button
        clickAddToBtn();
        Thread.sleep(1000);
        //choose a playlist from menu
        choosePlaylist();
        Thread.sleep(1000);
        //actual vs expected
        Assert.assertEquals(getAddToPlaylistMessage(),expectedSongAddedMessage);

    }

    public String getAddToPlaylistMessage(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void choosePlaylist() {
        WebElement playlist = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'TestPro Playlist')]"));
        playlist.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void selectFirstSong() {
        WebElement firstSong = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(songName);
    }


}
