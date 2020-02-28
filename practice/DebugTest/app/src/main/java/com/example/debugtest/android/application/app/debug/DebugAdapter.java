

/**
 * Created by yihuaqi on 10/26/16.
 */

public class DebugAdapter extends RecyclerView.Adapter<DebugAdapter.ViewHolder> {

    public static final String TAG = DebugAdapter.class.getSimpleName();
    protected final Context mContext;
    // TODO:
    private GoogleAccountClient mGoogleAccountClient;

    private boolean isShowUETools = false;
    private boolean isShowTranslationTool = false;

    public enum ViewType {
        EditText(R.layout.debug_item_edit_text),
        CheckBox(R.layout.debug_item_checkbox),
        TextView(R.layout.debug_item_text_view),
        Spinner(R.layout.debug_item_spinner_view),
        Separator(R.layout.debug_item_separator);
        public final int layoutId;

        ViewType(int id) {
            layoutId = id;
        }
    }

    public enum Item {
        DisableConfigurableChannel("Disable Configurable Channel", ViewType.CheckBox),
        DisableStreamPreload("Disable Stream Preload", ViewType.CheckBox),
        EnableBackupDNS("Enable Backup DNS", ViewType.CheckBox),
        EnableStreamProtobuf("Enable Stream Protobuf", ViewType.CheckBox),
        MultiLanguageEnable("enable multi language", ViewType.CheckBox),
        ImageTranslateEnable("Enable Image Translation", ViewType.CheckBox),
        MockAndroidId("mock android id last three numbers", ViewType.EditText),
        LittleAppTest("Little App Test", ViewType.TextView),
        QRCodeH5Jumper("QR Code H5 Jumper", ViewType.TextView),
        BINDPAYTM("bind paytm", ViewType.TextView),
        TestANR("TEST ANR", ViewType.TextView),
        TestOOM("TEST OOM", ViewType.TextView),
        TestFinalizeTimeOut("TEST Finalize Timeout", ViewType.TextView),
        ForceUseOldUgc("Use Old Ugc Tools", ViewType.CheckBox),
        ForceJumpToPost("Force Jump To Post", ViewType.CheckBox),
        ForceQuickUpload("ForceQuickUpload", ViewType.CheckBox),
        VIDEO_URL_PREVIEW("preview_url", ViewType.TextView),
        LIVE_PERMISSION("enable live permission", ViewType.CheckBox),
        ENABLE_X2C("enable x2c", ViewType.CheckBox),
        ENABLE_ASYNC_LAYOUT("enable async inflate", ViewType.CheckBox),
        MediaDownload("ImmortalMediaDownload", ViewType.TextView),
        SHOW_LIVE_GUIDE("Show live guide dialog", ViewType.CheckBox),
        LIVE_DEBUG_H5("Debug Live H5", ViewType.TextView),
        LIVE_SHOW_DEBUG_INFO("show live debug info", ViewType.CheckBox),
        LIVE_WATCH("watch_live", ViewType.EditText),
        DebugVeVideoEditor("Debug VE Video Editor", ViewType.TextView),
        CatMan("SuperCatMan", ViewType.TextView),
        DOUBLE_GAP("double_gap", ViewType.EditText),
        EnableImageRequestDebug("Enable Image Request Debug", ViewType.CheckBox),
        EnableNewCard("EnableNewImmersiveVideoCard", ViewType.CheckBox),
        CrazyVideoDownload("CrazyVideoDownload", ViewType.CheckBox),
        EnableMainFeedNewCard("EnableMainFeedVideoCard", ViewType.CheckBox),
        EnableNewMediaViewer("EnableNewMediaViewer", ViewType.CheckBox),
        Music("Music", ViewType.TextView),
        FeedBack("FeedBack", ViewType.TextView),
        UETool("UETool", ViewType.TextView),
        LanguageDialogStyle("Language Dialog Style", ViewType.EditText),
        Location("choose city", ViewType.Spinner),
        LocationPage("start BDLocation Test", ViewType.TextView),
        Longitude("set longitude", ViewType.EditText),
        Latitude("set latitude", ViewType.EditText),
        NearbyStyle("Nearby Style", ViewType.Spinner),
        TranslationTool("Enable Translation Tool", ViewType.TextView),
        UseNewLoginStyle("Use new login style", ViewType.CheckBox),
        VideoUseUrlWithDataLoader("Video Use MediaLoader To PreLoad", ViewType.CheckBox),
        VideoPreloadRadical("Enable Video Preload Radical", ViewType.CheckBox),
        UseVideoPreload("Enable Video Preload", ViewType.CheckBox),
        TTVideoUseTTNet("TTVideo Use TTNet", ViewType.CheckBox),
        ImageLoaderUseTTNet("ImageLoader Use TTNet", ViewType.CheckBox),
        AlwaysLoginAsNewUser("Always login as new user", ViewType.CheckBox),
        DisableAppLogEncryption("Disable AppLog Encryption", ViewType.CheckBox),
        EnableScreenShot("Enable Screen Shot for BuzzShare", ViewType.CheckBox),
        DebugConsole("Show Debug Console", ViewType.CheckBox),
        ShowArticleWebType(, ViewType.CheckBox),
        FabricDebug("Fabric Debug", ViewType.TextView),
        AutoCleanInShortDelay(, ViewType.CheckBox),
        InAppBilling("In App Billing", ViewType.TextView),
        RepostDebug("Repost Debug", ViewType.TextView),
        MigrateNrSavedArticle("Migrate Nr Saved Article", ViewType.TextView),
        WakeUpTimes("Wake Up Times", ViewType.TextView),
        ShortcutBadge("Short Cut Badge", ViewType.EditText),
        AsyncEvent("Async Event", ViewType.EditText),
        GoogleLogin("Google Login", ViewType.CheckBox),
        UseHttp("Use Http", ViewType.CheckBox),
        NativeAdPriorityOption("Enable Native Ads Priority", ViewType.CheckBox),
        NativeAdPriorityEdit("Native Ads Priority", ViewType.TextView),
        InterstitialAdPriorityOption("Enable Interstitial Ads Priority", ViewType.CheckBox),
        InterstitialPriorityEdit("Interstitial Ads Priority", ViewType.TextView),
        AdProviderId("Show Ad Provider Id", ViewType.CheckBox),
        AdPreloadEdit("Ads Preload Status", ViewType.TextView),
        AdStyleEdit("Ad Style", ViewType.TextView),
        AppUsage("App Usage Summ", ViewType.TextView),
        FpsMeter("Enable FPS Meter", ViewType.CheckBox),
        AlwaysShowLoginPopup("Always show login popup", ViewType.CheckBox),
        AlwaysGetAppSettings("Always get app settings", ViewType.CheckBox),
        ForceSwitchSession("Force Switch Session", ViewType.CheckBox),
        AlwaysSendSampleHttp("Always send sample http log", ViewType.CheckBox),
        FixOkHttpProxy("Fix Ok Http Proxy issue", ViewType.CheckBox),
        ApplyMdDesignOnTabLayout("Apply MD Design on TabLayout", ViewType.CheckBox),
        AlwaysShowVideoTabTip("Always show video tab tip", ViewType.CheckBox),
        AlwaysShowBottomTabRefreshTip("Always show bottom tab refresh tip", ViewType.CheckBox),
        AlwaysJumpToComment("Always jump to detail comment section", ViewType.CheckBox),
        //        AddShareDestination("Add share destination", ViewType.CheckBox),
        AlwaysShowVideoErrorContent("Always Show Video Error", ViewType.CheckBox),
        AlwaysShowPullToRefreshGuide("Always show pull to refresh guide", ViewType.CheckBox),
        UseTextureViewRenderView("Use SurfaceView", ViewType.CheckBox),
        ShowMediaPlayerUsed("Show Used MediaPlayer", ViewType.CheckBox),
        UseAsyncMediaPlayer("Use async MediaPlayer", ViewType.CheckBox),
        ShowVideoBitrateLayout("Show Video Bitrate Info", ViewType.CheckBox),
        SelectMediaPlayerSwitch("MediaPlayer Type Switch", ViewType.CheckBox),
        SelectMediaPlayerType("MediaPlayer Type", ViewType.TextView),
        TestAppCurrActiveEvent("Test App Current Active Event", ViewType.CheckBox),
        LocalPushTest("Local Push Enable Local Time Test", ViewType.CheckBox),
        DoNotBindAd("Don't Bind Ad", ViewType.CheckBox),
        ShowTwoLineRelativeNews("Show Two Lines Relative News", ViewType.CheckBox),
        TestPreferenceProperty("Test Preference Property", ViewType.EditText),
        TestAppConfig("Update App Config", ViewType.EditText),
        TryNetChannelSelect("Try NetChannelSelect", ViewType.EditText),
        GcmDebug("Gcm Debug", ViewType.TextView),
        DynamicsDebug("Dynamics Debug", ViewType.TextView),
        TTNetDebug("TTNet Debug", ViewType.TextView),
        ShowAddToDebug("Show AddtoDebug", ViewType.CheckBox),
        PushDetailBackStrategy("Push Detail Back Strategy", ViewType.EditText),
        ShowFeedItemTime("Show Feed Time", ViewType.CheckBox),
        SwipToNextPage("Swip To Next Page", ViewType.CheckBox),
        SwipToRelated("Swip To Related Page", ViewType.CheckBox),
        NetGetNetwork("NetGetNetwork", ViewType.TextView),
        NetGetStream("NetGetStream", ViewType.TextView),
        NetSearchSuggestion("NetSearchSuggestion", ViewType.EditText),
        NetSDK("Net SDK Version", ViewType.EditText),
        TTNET_CRONET_ENABLE("TTNet Cronet Enable", ViewType.CheckBox),
        NativeCrash("Trigger native crash", ViewType.EditText),
        CollectNativeCrash("Collect native crash", ViewType.EditText),
        DegreeYoutubeLeech("Degree Youtube Leech", ViewType.CheckBox),
        ResetUser("Reset User", ViewType.CheckBox),
        HTTP1Only("Http1 Only", ViewType.CheckBox),
        GetAppLogConfig("Get app log config", ViewType.TextView),
        BlockThreshold("Block Time", ViewType.EditText),
        StartSearch("Start Search", ViewType.TextView),
        CommunityDebug("Community Debug", ViewType.TextView),
        BuzzAlwaysShowIntro("Always show buzz intro", ViewType.CheckBox),
        BuzzIntroStyle("Show Invitation style", ViewType.CheckBox),
        Separator("Separator", ViewType.Separator),
        DemandTest("Demand Test", ViewType.TextView),
        BuzzAlwaysSelectLanguage("Buzz always select language", ViewType.CheckBox),
        MagicBrowser("Router Manager", ViewType.EditText),
        ScriptUpdate("ScriptUpdate", ViewType.EditText),
        UgcChallengeDebug("Enable UgcChallenge", ViewType.CheckBox),
        ImmersiveDebug("Enable immersive", ViewType.CheckBox),
        ImageViewDebug("Enable ImageView Debug", ViewType.CheckBox),
        ImageViewReuse("Enable ImageView Reuse", ViewType.CheckBox),
        ImmersiveVideoVertical("immersive video vertical",ViewType.CheckBox),
        CricketAlwaysPull("Enable Cricket Always Pull", ViewType.CheckBox),
        IMSetting("enter IM setting page", ViewType.TextView),
        TestEffect("Enable Test Effect", ViewType.CheckBox),
        UgcDisableImageCompress("UGC disable image compression", ViewType.CheckBox),
        UgcUseNewLubanComputeSize("UGC use new Luban compute size", ViewType.CheckBox),
        AndroidGroupInnerCode("InnerCode-0619-21:30", ViewType.TextView),
        PRINT_APK_INJECT_INFO("Print Apk Inject Info", ViewType.TextView),
        FileStructure("Print Apk file structure", ViewType.TextView),
        USE_SEARCH_RESULT_H5_ONLINE("Use Search Result H5 online", ViewType.CheckBox),
        USE_SEARCH_RESULT_H5_LOCAL("Use Search Result H5 local", ViewType.CheckBox),
        SEARCH_RESULT_USE_H5("Search Result Use H5", ViewType.CheckBox),
        USE_VOICE_SEARCH("Use Voice Search", ViewType.CheckBox),
        USE_UGC_PRELOAD("Use UGC Preload", ViewType.CheckBox),
        USE_DEFAULT_EFFECTS_CONFIG("Use default mv preload config(first check Use UGC Preload)", ViewType.CheckBox),

        ("UGC Entrance Type(-1,0,1,2)", ViewType.EditText),
        DebugGoogleMap("Debug with google map",ViewType.TextView),
        IMAGE_PRELOAD_DOWNLOAD_DURATION_THRESHOLD("Preload Original Image Threshold", ViewType.Spinner);