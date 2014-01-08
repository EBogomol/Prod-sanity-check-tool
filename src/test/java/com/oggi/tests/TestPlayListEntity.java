package com.oggi.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPlayListEntity extends EntityCreationPage {
    private String widgetId;


    BasePage basePage = new BasePage();
    PlayListEntityCreation playListEntityCreation = new PlayListEntityCreation();
    LoginPage loginPage = new LoginPage();

    @Test(priority = 1)
    public void playlistEntityIsCreated() {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("Playlist");
        playListEntityCreation.createPlayListEntity("TestPlayListEntity_RPS",WidgetCreationPage.widgetID,BaseWidgetCreationPage.bw_wid_ID, true);
        Assert.assertTrue(playListEntityCreation.checkAbilityToCreatePlaylist(), "Playlist entity can't be created");
    }

    //@Test(priority = 2)
    public void playlistIsEdited() {
        loginPage.loginToSystem(Login, Password);
        openEditPage(PlayListEntityCreation.playListEntityID, "Playlist");
        playListEntityCreation.addNSImage();
        playListEntityCreation.addVideoList();
        playListEntityCreation.changePlayListSettings();
        Assert.assertTrue(playListEntityCreation.checkAbilityToEditPlayList(), "Playlist entity can't be edited");
    }

    //@Test (priority = 3)
    public void playlistCantBeCreatedWithoutNsI() {
        loginPage.loginToSystem(Login, Password);
        basePage.openCreationPage("Playlist");
        playListEntityCreation.createPlayListEntity("TestPlayListEntity_RPS_test2",WidgetCreationPage.widgetID, BaseWidgetCreationPage.bw_wid_ID, false);
        Assert.assertTrue(playListEntityCreation.checkAbilityCreatePlaylistWithoutNsI(), "Playlist entity can't be edited");
    }
}



