package rockstar.client;



















import rockstar.client.rotation.*;
import rockstar.client.render.*;
import rockstar.client.notification.*;
import rockstar.client.module.*;
import rockstar.client.i18n.*;
import rockstar.client.esp.*;
import rockstar.client.asset.*;
import rockstar.client.internal.ui.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.rotation.*;
import rockstar.client.internal.render.*;
import rockstar.client.internal.network.*;
import rockstar.client.internal.game.*;
import rockstar.client.internal.framework.*;
import rockstar.client.internal.core.*;
import rockstar.client.internal.config.*;
import rockstar.client.internal.command.*;
import rockstar.client.internal.auth.*;
import globals.client.RocknetListener;
import globals.client.api.RockNetClient;
import globals.client.auth.SessionManager;
import globals.client.snowball.SnowballManager;
import globals.client.ui.RocknetMenu;
import lombok.Generated;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.funtimeevents.api.FunTimeEventsAPI;
import net.minecraft.entity.Entity;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum RockstarClient implements MinecraftClientAccess {
   internalField0240;

   public static final String internalField0248 = "Rockstar";
   public static final String internalField0247 = "2.1";
   public static final String internalField1077 = "Rockstar".toLowerCase();
   public static final String internalField1076 = "https://ftapi.rockstar.pub/v1/";
   public static final String internalField1079 = "rockstar.pub";
   public static final int internalField0227 = 443;
   public static final boolean internalField0277 = true;
   public static final String internalField1078 = "https://rockstar.pub";
   public static final Logger internalField0572 = LoggerFactory.getLogger(internalField1077);
   public static Entity internalField0410;
   private ScriptInternal069 internalField0159;
   private CoreInternal072 internalField0396;
   private ModuleManager internalField0404;
   private CommandInternal001 internalField0421;
   private ScriptInternal071 internalField0163;
   private GameInternal024 internalField0156;
   private RotationManager internalField0120;
   private RotationInternal017 internalField0774;
   private GameInternal026 internalField0392;
   private ScriptInternal158 internalField0516;
   private ScriptInternal070 internalField0161;
   private NotificationManager internalField0468;
   private ScriptInternal068 internalField0044;
   private ScriptInternal072 internalField0390;
   private FrameworkInternal001 internalField0730;
   private ScriptInternal143 internalField0580;
   private ScriptInternal103 internalField0938;
   private ScriptInternal093 internalField0399;
   private ScriptInternal092 internalField0398;
   private ScriptInternal094 internalField0562;
   private ScriptInternal081 internalField0433;
   private GameInternal027 internalField0561;
   private ConfigInternal026 internalField0753;
   private ScriptInternal089 internalField0388;
   private boolean internalField0276;
   private RockNetClient internalField0235;
   private ScriptInternal082 internalField0434;
   private ScriptInternal087 internalField0444;
   private ConfigInternal029 internalField0160;
   private ScriptInternal014 internalField0712;
   private CoreInternal081 internalField0375;
   private RocknetMenu internalField0660;
   private ScriptInternal146 internalField0367;
   boolean internalField1099;

   public void initialize() {
      internalField0572.info("Initializing {}...", "Rockstar");
      SessionManager.bootstrapEarly("https://rockstar.pub/api/v1");
      this.internalField0516 = new ScriptInternal158();
      this.internalField0561 = new GameInternal027();
      this.internalField0434 = new ScriptInternal082();
      this.internalField0159 = new ScriptInternal069();
      this.internalField0163 = new ScriptInternal071();
      this.internalField0388 = new ScriptInternal089();
      this.internalField0396 = new CoreInternal072();
      this.internalField0156 = new GameInternal024();
      this.internalField0120 = new RotationManager(new RotationEventHandler());
      this.internalField0774 = new RotationInternal017();
      this.internalField0392 = new GameInternal026();
      this.internalField0161 = new ScriptInternal070();
      this.internalField0404 = new ModuleManager(new ScriptInternal036(), new ScriptInternal037());
      this.internalField0938 = new ScriptInternal103();
      this.internalField0580 = new ScriptInternal143();
      this.internalField0468 = new NotificationManager();
      this.internalField0161.internalMethod05330();
      this.internalField0404.registerModules();
      this.internalField0404.enableDefaultModules();
      this.internalField0235 = RockNetClient.init("rockstar.pub", 443, true);
      this.internalField0235.setListener(new RocknetListener());

      try {
         FunTimeEventsAPI.builder().userAgent("Rockstar").baseUrl("https://ftapi.rockstar.pub/v1/").build();
      } catch (Throwable localValue2) {
         internalField0572.warn("FunTimeEvents SDK \u043d\u0435 \u043f\u043e\u0434\u043d\u044f\u043b\u0441\u044f: {}", localValue2.toString());
      }

      NetworkInternal014.internalMethod01801(this.internalField0235.getHttpBase());
      AssetPackInstaller.internalMethod02290(this.internalField0235.getHttpBase());
      SnowballManager.getInstance().register();
      EspManager.internalMethod06726().internalMethod03144();
      this.internalField0044 = new ScriptInternal068();
      this.internalField0044.internalMethod03462();
      this.internalField0444 = new ScriptInternal087();
      this.internalField0160 = new ConfigInternal029();
      this.internalField0712 = new ScriptInternal014();
      this.internalField0421 = new CommandInternal001();
      this.internalField0421.internalMethod03368();
      this.internalField0390 = new ScriptInternal072();
      this.internalField0730 = new FrameworkInternal001();
      this.internalField0753 = new ConfigInternal026();
      this.internalField0753.internalMethod05545();
      this.internalField0161.internalMethod05336();
      this.internalField0235.connect();
      SessionManager.bootstrapAsync(this.internalField0235);
      ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
         public Identifier getFabricId() {
            return RockstarClient.id("after_shader_load");
         }

         public void reload(ResourceManager localValue1) {
            if (!RockstarClient.this.internalField1099) {
               Fonts.internalMethod05887();
               CoreInternal003.internalMethod02914();
               RenderInternal001.internalMethod04681();
            }
         }
      });
      RenderPipeline.internalMethod01907();
      RenderInternal001.internalMethod02836(true);
      LanguageManager.internalMethod05353();
      this.internalField0367 = new ScriptInternal146();
      this.internalField0398 = new ScriptInternal092();
      this.internalField0399 = new ScriptInternal093();
      this.internalField0562 = new ScriptInternal094();
      this.internalField0433 = new ScriptInternal081();
      String localValue1 = System.getProperty("user.name");
      this.internalField0276 = !System.getProperty("os.name").toLowerCase().contains("windows");
      if (!this.internalField0276 && !localValue1.equals("sheluvparis")) {
         this.internalField0156.internalMethod00959();
      }

      UiInternal017.internalMethod05313();
      UiInternal034.internalMethod01735();
      new CoreInternal060();
      new ScriptInternal157();
      NetworkInternal013.internalMethod07531().internalMethod01544();
      internalField0572.info("{} initialized", "Rockstar");
   }

   public void shutdown() {
      internalField0572.info("Shutting down...");
      if (!this.internalMethod06896()) {
         this.internalField0044.internalMethod07805();
         if (this.internalField0160 != null) {
            this.internalField0160.internalMethod05805();
         }

         this.internalField0753.internalMethod01444().internalMethod03767();
      }

      this.internalField0235.close();
      if (this.internalField0444 != null) {
         this.internalField0444.internalMethod08550();
      }

      if (this.internalField0160 != null) {
         this.internalField0160.internalMethod08886();
      }

      this.internalField0161.internalMethod08923();
      this.internalMethod00631(false);
   }

   public static RockstarClient getInstance() {
      return internalField0240;
   }

   public static Identifier id(String localValue0) {
      return Identifier.of(internalField1077, localValue0);
   }

   @Generated
   public ScriptInternal069 internalMethod03317() {
      return this.internalField0159;
   }

   @Generated
   public CoreInternal072 internalMethod04467() {
      return this.internalField0396;
   }

   @Generated
   public ModuleManager getModuleManager() {
      return this.internalField0404;
   }

   @Generated
   public CommandInternal001 internalMethod05348() {
      return this.internalField0421;
   }

   @Generated
   public ScriptInternal071 internalMethod03375() {
      return this.internalField0163;
   }

   @Generated
   public GameInternal024 internalMethod03315() {
      return this.internalField0156;
   }

   @Generated
   public RotationManager internalMethod02368() {
      return this.internalField0120;
   }

   @Generated
   public RotationInternal017 internalMethod07318() {
      return this.internalField0774;
   }

   @Generated
   public GameInternal026 internalMethod04463() {
      return this.internalField0392;
   }

   @Generated
   public ScriptInternal158 internalMethod05636() {
      return this.internalField0516;
   }

   @Generated
   public ScriptInternal070 internalMethod03371() {
      return this.internalField0161;
   }

   @Generated
   public NotificationManager internalMethod02503() {
      return this.internalField0468;
   }

   @Generated
   public ScriptInternal068 internalMethod02152() {
      return this.internalField0044;
   }

   @Generated
   public ScriptInternal072 internalMethod05155() {
      return this.internalField0390;
   }

   @Generated
   public FrameworkInternal001 internalMethod00061() {
      return this.internalField0730;
   }

   @Generated
   public ScriptInternal143 internalMethod06191() {
      return this.internalField0580;
   }

   @Generated
   public ScriptInternal103 internalMethod01271() {
      return this.internalField0938;
   }

   @Generated
   public ScriptInternal093 internalMethod04469() {
      return this.internalField0399;
   }

   @Generated
   public ScriptInternal092 internalMethod04468() {
      return this.internalField0398;
   }

   @Generated
   public ScriptInternal094 internalMethod06122() {
      return this.internalField0562;
   }

   @Generated
   public ScriptInternal081 internalMethod04978() {
      return this.internalField0433;
   }

   @Generated
   public GameInternal027 internalMethod06121() {
      return this.internalField0561;
   }

   @Generated
   public ConfigInternal026 internalMethod01001() {
      return this.internalField0753;
   }

   @Generated
   public ScriptInternal089 internalMethod04407() {
      return this.internalField0388;
   }

   @Generated
   public boolean internalMethod06893() {
      return this.internalField0276;
   }

   @Generated
   public RockNetClient internalMethod06050() {
      return this.internalField0235;
   }

   @Generated
   public ScriptInternal082 internalMethod04979() {
      return this.internalField0434;
   }

   @Generated
   public ScriptInternal087 internalMethod05030() {
      return this.internalField0444;
   }

   @Generated
   public ConfigInternal029 internalMethod03318() {
      return this.internalField0160;
   }

   @Generated
   public ScriptInternal014 internalMethod04226() {
      return this.internalField0712;
   }

   @Generated
   public CoreInternal081 internalMethod04334() {
      return this.internalField0375;
   }

   @Generated
   public RocknetMenu internalMethod01773() {
      return this.internalField0660;
   }

   @Generated
   public ScriptInternal146 internalMethod04298() {
      return this.internalField0367;
   }

   @Generated
   public boolean internalMethod06896() {
      return this.internalField1099;
   }

   @Generated
   public void internalMethod01597(RockNetClient localValue1) {
      this.internalField0235 = localValue1;
   }

   @Generated
   public void internalMethod02331(CoreInternal081 localValue1) {
      this.internalField0375 = localValue1;
   }

   @Generated
   public void internalMethod06176(RocknetMenu localValue1) {
      this.internalField0660 = localValue1;
   }

   @Generated
   public void internalMethod00631(boolean localValue1) {
      this.internalField1099 = localValue1;
   }
}
