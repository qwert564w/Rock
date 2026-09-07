package rockstar.client.internal.auth;








import rockstar.client.network.*;
import rockstar.client.data.*;
import rockstar.client.auth.*;
import rockstar.client.internal.network.*;
import rockstar.client.internal.core.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.CookieManager;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;

public class AuthInternal029 extends AuthInternal028 {
   private final ConfigInternal016 internalField0728;

   public AuthInternal029(RockstarHttpClient localValue1, OAuthClientConfig localValue2, ConfigInternal016 localValue3) {
      super(localValue1, localValue2);
      this.internalField0728 = localValue3;
   }

   @Override
   public OAuthToken internalMethod04761() throws IOException {
      return this.internalMethod04665(this.internalField0728);
   }

   public OAuthToken internalMethod04665(ConfigInternal016 localValue1) throws IOException {
      CookieManager localValue2 = new CookieManager();
      HttpPostRequest localValue3 = this.internalMethod00305(localValue1, localValue2);
      RockstarHttpResponse localValue4 = this.internalMethod02660(localValue3);
      String localValue5 = localValue4.internalMethod04855("Location").orElseThrow(() -> new IllegalStateException("Failed to get redirect url"));
      String localValue6 = NetworkInternal004.internalMethod07963(localValue5)
         .internalMethod00462()
         .internalMethod06443("code")
         .orElseThrow(() -> new IllegalStateException("Failed to extract auth code from redirect url"));
      return this.internalField0058.internalMethod07532(new AuthInternal024(this.internalField0727, localValue6));
   }

   private HttpPostRequest internalMethod00305(ConfigInternal016 localValue1, CookieManager localValue2) throws IOException {
      URL localValue3 = NetworkInternal004.internalMethod02979(this.internalField0727.internalMethod01376().internalMethod06755())
         .internalMethod00462()
         .internalMethod01498(this.internalField0727.internalMethod00213())
         .internalMethod06913()
         .internalMethod02292();
      HttpGetRequest localValue4 = new HttpGetRequest(localValue3);
      localValue4.internalMethod00332(localValue2);
      localValue4.internalMethod01193("Accept", MediaTypes.internalField1792.internalMethod05675());
      JsonObjectNode localValue5 = this.internalField0058.internalMethod04616(localValue4, localValue1x -> {
         if (localValue1x.internalMethod00588() >= 300) {
            Optional localValue2x = localValue1x.internalMethod04855("Location");
            if (localValue2x.isPresent()) {
               NetworkInternal004.InternalType0484 localValue3x = NetworkInternal004.internalMethod07963((String)localValue2x.get()).internalMethod00462();
               Optional localValue4x = localValue3x.internalMethod06443("error");
               Optional localValue5x = localValue3x.internalMethod06443("error_description");
               if (localValue4x.isPresent() && localValue5x.isPresent()) {
                  throw new CoreInternal017(localValue1x, (String)localValue4x.get(), (String)localValue5x.get());
               }
            }

            throw new HttpRequestException(localValue1x);
         } else {
            return this.internalMethod00529(localValue1x.internalMethod02509().internalMethod04320());
         }
      });
      HashMap localValue7 = new HashMap();
      String localValue6;
      switch (this.internalField0727.internalMethod01376()) {
         case internalField0726:
            localValue6 = localValue5.internalMethod03457("urlPost");
            String localValue8 = localValue5.internalMethod03457("sFTTag");
            String localValue9 = localValue8.substring(localValue8.indexOf("value=\"") + 7);
            localValue9 = localValue9.substring(0, localValue9.indexOf("\""));
            String localValue10 = localValue8.substring(localValue8.indexOf("name=\"") + 6);
            localValue10 = localValue10.substring(0, localValue10.indexOf("\""));
            localValue7.put("login", localValue1.internalMethod00235());
            localValue7.put("loginfmt", localValue1.internalMethod00235());
            localValue7.put("passwd", localValue1.internalMethod04989());
            localValue7.put(localValue10, localValue9);
            break;
         case internalField0725:
         case internalField1288:
            localValue6 = NetworkInternal004.internalMethod07963(localValue5.internalMethod03457("urlPost"))
               .internalMethod08247(localValue3.getProtocol())
               .internalMethod09027(localValue3.getHost())
               .internalMethod02292()
               .toString();
            localValue7.put("login", localValue1.internalMethod00235());
            localValue7.put("loginfmt", localValue1.internalMethod00235());
            localValue7.put("passwd", localValue1.internalMethod04989());
            localValue7.put("ctx", localValue5.internalMethod03457("sCtx"));
            localValue7.put(localValue5.internalMethod03457("sFTName"), localValue5.internalMethod03457("sFT"));
            break;
         default:
            throw new IllegalStateException("Unsupported MsaEnvironment: " + this.internalField0727.internalMethod01376());
      }

      HttpPostRequest localValue11 = new HttpPostRequest(localValue6);
      localValue11.internalMethod00332(localValue2);
      localValue11.internalMethod01193("Accept", MediaTypes.internalField1792.internalMethod05675());
      localValue11.internalMethod07111(new FormRequestBody(localValue7));
      return localValue11;
   }

   private RockstarHttpResponse internalMethod02660(RockstarHttpRequest localValue1) throws IOException {
      RockstarHttpResponse localValue2 = this.internalField0058.internalMethod03397(localValue1);
      if (localValue2.internalMethod00588() != 302) {
         if (!localValue2.internalMethod02509().internalMethod05122().internalMethod05675().equals(MediaTypes.internalField1792.internalMethod05675())) {
            throw new CoreInternal034(localValue2, "Wrong content type");
         } else {
            String localValue3 = localValue2.internalMethod02509().internalMethod04320();
            if (localValue3.contains("<body onload=\"javascript:DoSubmit();\">")) {
               String localValue7 = localValue3.substring(localValue3.indexOf("action=\"") + 8);
               localValue7 = localValue7.substring(0, localValue7.indexOf("\""));
               String localValue5 = NetworkInternal004.internalMethod02979(localValue7).internalMethod00462().internalMethod06443("ru").orElse(null);
               if (localValue5 == null) {
                  throw new IllegalStateException("Failed to extract return url from html");
               } else {
                  HttpGetRequest localValue6 = new HttpGetRequest(localValue5);
                  localValue6.internalMethod00332(localValue1.internalMethod02997());
                  localValue6.internalMethod01193("Accept", MediaTypes.internalField1792.internalMethod05675());
                  return this.internalMethod02660(localValue6);
               }
            } else {
               JsonObjectNode localValue4 = this.internalMethod00529(localValue3);
               switch (this.internalField0727.internalMethod01376()) {
                  case internalField0726:
                     if (localValue4.internalMethod09165("sErrorCode") && localValue4.internalMethod09165("sErrTxt")) {
                        throw new CoreInternal017(localValue2, localValue4.internalMethod03457("sErrorCode"), localValue4.internalMethod03457("sErrTxt"));
                     }
                     break;
                  case internalField0725:
                  case internalField1288:
                     if (localValue4.internalMethod09165("iErrorCode") && localValue4.internalMethod09165("strServiceExceptionMessage")) {
                        throw new CoreInternal017(localValue2, localValue4.internalMethod03457("iErrorCode"), localValue4.internalMethod03457("strServiceExceptionMessage"));
                     }
                     break;
                  default:
                     throw new IllegalStateException("Unsupported MsaEnvironment: " + this.internalField0727.internalMethod01376());
               }

               throw new IllegalStateException(
                  "Failed to extract config from html. This most likely indicates that the application config or credentials are not valid"
               );
            }
         }
      } else {
         return localValue2;
      }
   }

   private JsonObjectNode internalMethod00529(String localValue1) {
      String localValue2;
      switch (this.internalField0727.internalMethod01376()) {
         case internalField0726:
            int localValue5 = localValue1.indexOf("var ServerData = ");
            if (localValue5 == -1) {
               throw new IllegalStateException("Failed to find config start in html");
            }

            localValue2 = localValue1.substring(localValue5 + 17);
            break;
         case internalField0725:
         case internalField1288:
            int localValue3 = localValue1.indexOf("$Config=");
            if (localValue3 == -1) {
               throw new IllegalStateException("Failed to find config start in html");
            }

            localValue2 = localValue1.substring(localValue3 + 8);
            break;
         default:
            throw new IllegalStateException("Unsupported MsaEnvironment: " + this.internalField0727.internalMethod01376());
      }

      try {
         JsonReader localValue6 = new JsonReader(new StringReader(localValue2));
         localValue6.setLenient(true);
         return ConfigInternal003.internalMethod00526(localValue6).internalMethod04512();
      } catch (Throwable localValue4) {
         throw new IllegalStateException(
            "Failed to extract config from html. This most likely indicates that the application config or credentials are not valid", localValue4
         );
      }
   }
}
