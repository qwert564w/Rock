package rockstar.client.internal.network;


import rockstar.client.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import lombok.Generated;
import org.jetbrains.annotations.ApiStatus;
import rockstar.client.internal.network.NetworkInternal003;

public class NetworkInternal004 {
    private String internalField0248;
    private String internalField0247;
    private int internalField0227 = -1;
    private String internalField1077;
    private String internalField1076;
    private String internalField1079;
    private String internalField1078;

    public static NetworkInternal004 internalMethod02148() {
        return new NetworkInternal004();
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public static NetworkInternal004 internalMethod01610(String string) throws MalformedURLException {
        return NetworkInternal004.internalMethod02979(string);
    }

    public static NetworkInternal004 internalMethod02979(String string) throws MalformedURLException {
        return new NetworkInternal004(new URL(string));
    }

    public static NetworkInternal004 internalMethod07963(String string) throws IllegalArgumentException {
        return new NetworkInternal004(URI.create(string));
    }

    public static NetworkInternal004 internalMethod03347(URL uRL) {
        return new NetworkInternal004(uRL);
    }

    public static NetworkInternal004 internalMethod01262(URI uRI) {
        return new NetworkInternal004(uRI);
    }

    public NetworkInternal004() {
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public NetworkInternal004(String string) throws MalformedURLException {
        this(new URL(string));
    }

    public NetworkInternal004(URL uRL) {
        this.internalField0248 = uRL.getProtocol();
        this.internalField0247 = this.internalMethod09493(uRL.getHost());
        this.internalField0227 = uRL.getPort();
        this.internalField1077 = this.internalMethod09493(uRL.getPath());
        this.internalField1076 = this.internalMethod09493(uRL.getQuery());
        this.internalField1079 = this.internalMethod09493(uRL.getUserInfo());
        this.internalField1078 = this.internalMethod09493(uRL.getRef());
    }

    public NetworkInternal004(URI uRI) {
        this.internalField0248 = this.internalMethod09493(uRI.getScheme());
        this.internalField0247 = this.internalMethod09493(uRI.getHost());
        this.internalField0227 = uRI.getPort();
        this.internalField1077 = this.internalMethod09493(uRI.getPath());
        this.internalField1076 = this.internalMethod09493(uRI.getQuery());
        this.internalField1079 = this.internalMethod09493(uRI.getUserInfo());
        this.internalField1078 = this.internalMethod09493(uRI.getFragment());
    }

    public boolean internalMethod05124() {
        return this.internalField0248 != null;
    }

    public String internalMethod01817() {
        return this.internalField0248;
    }

    public String internalMethod03831(String string) {
        return this.internalField0248 == null ? string : this.internalField0248;
    }

    public NetworkInternal004 internalMethod08247(String string) {
        this.internalField0248 = this.internalMethod09493(string);
        return this;
    }

    public boolean internalMethod05126() {
        return this.internalField0247 != null;
    }

    public String internalMethod06449() {
        return this.internalField0247;
    }

    public String internalMethod00848(String string) {
        return this.internalField0247 == null ? string : this.internalField0247;
    }

    public NetworkInternal004 internalMethod09027(String string) {
        this.internalField0247 = this.internalMethod09493(string);
        return this;
    }

    public boolean internalMethod07756() {
        return this.internalField0227 >= 0;
    }

    public int internalMethod05123() {
        return this.internalField0227;
    }

    public int internalMethod00414(int n) {
        return this.internalField0227 < 0 ? n : this.internalField0227;
    }

    public NetworkInternal004 internalMethod04023(int n) {
        if (n > 65535) {
            throw new IllegalArgumentException("Port must not be greater than 65535");
        }
        this.internalField0227 = n;
        return this;
    }

    public boolean internalMethod07757() {
        return this.internalField1077 != null;
    }

    public String internalMethod08524() {
        return this.internalField1077;
    }

    public String internalMethod09130(String string) {
        return this.internalField1077 == null ? string : this.internalField1077;
    }

    public NetworkInternal004 internalMethod07727(String string) {
        this.internalField1077 = this.internalMethod09493(string);
        return this;
    }

    public boolean internalMethod07768() {
        return this.internalField1076 != null;
    }

    public String internalMethod07894() {
        return this.internalField1076;
    }

    public String internalMethod07767(String string) {
        return this.internalField1076;
    }

    public NetworkInternal004 internalMethod09626(String string) {
        this.internalField1076 = this.internalMethod09493(string);
        return this;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public InternalType0365 internalMethod03071() {
        return new InternalType0365();
    }

    public InternalType0484 internalMethod00462() {
        return new InternalType0484();
    }

    public boolean internalMethod07770() {
        return this.internalField1079 != null;
    }

    public String internalMethod08249() {
        return this.internalField1079;
    }

    public String internalMethod08962(String string) {
        return this.internalField1079 == null ? string : this.internalField1079;
    }

    public NetworkInternal004 internalMethod09767(String string) {
        this.internalField1079 = this.internalMethod09493(string);
        return this;
    }

    public boolean internalMethod09299() {
        return this.internalField1078 != null;
    }

    public String internalMethod09135() {
        return this.internalField1078;
    }

    public String internalMethod09153(String string) {
        return this.internalField1078 == null ? string : this.internalField1078;
    }

    public NetworkInternal004 internalMethod09364(String string) {
        this.internalField1078 = this.internalMethod09493(string);
        return this;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public String internalMethod09532() {
        return this.internalMethod09135();
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public NetworkInternal004 internalMethod09530(String string) {
        return this.internalMethod09364(string);
    }

    public URL internalMethod02292() throws MalformedURLException {
        return new URL(this.toString());
    }

    public URI internalMethod02291() {
        return URI.create(this.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.internalField0248 != null) {
            stringBuilder.append(this.internalField0248).append("://");
        }
        if (this.internalField1079 != null) {
            stringBuilder.append(this.internalField1079).append("@");
        }
        if (this.internalField0247 != null) {
            stringBuilder.append(this.internalField0247);
        }
        if (this.internalField0227 >= 0) {
            stringBuilder.append(":").append(this.internalField0227);
        }
        if (this.internalField1077 != null) {
            if (!this.internalField1077.startsWith("/")) {
                stringBuilder.append("/");
            }
            stringBuilder.append(this.internalField1077);
        }
        if (this.internalField1076 != null) {
            stringBuilder.append("?").append(this.internalField1076);
        }
        if (this.internalField1078 != null) {
            stringBuilder.append("#").append(this.internalField1078);
        }
        return stringBuilder.toString();
    }

    private String internalMethod09493(String string) {
        return string == null || string.isEmpty() ? null : string;
    }

    public static class InternalType0483 {
        private String internalField0248;
        @Nullable
        private String internalField0247;

        public InternalType0483(String string) {
            this.internalField0248 = string;
        }

        public InternalType0483(String string, @Nullable String string2) {
            this.internalField0248 = string;
            this.internalField0247 = string2;
        }

        @Generated
        public String internalMethod03387() {
            return this.internalField0248;
        }

        @Nullable
        @Generated
        public String internalMethod06545() {
            return this.internalField0247;
        }

        @Generated
        public void internalMethod03551(String string) {
            this.internalField0248 = string;
        }

        @Generated
        public void internalMethod02100(@Nullable String string) {
            this.internalField0247 = string;
        }
    }

    public class InternalType0484 {
        private final List<InternalType0483> internalField0416 = new ArrayList<InternalType0483>();

        public InternalType0484() {
            String string = NetworkInternal004.this.internalMethod07894();
            if (string != null && !string.isEmpty()) {
                for (String string2 : string.split("&")) {
                    String[] stringArray = string2.split("=", 2);
                    if (stringArray.length == 2) {
                        this.internalField0416.add(new InternalType0483(NetworkInternal003.internalMethod00033(stringArray[0]), NetworkInternal003.internalMethod00033(stringArray[1])));
                        continue;
                    }
                    this.internalField0416.add(new InternalType0483(NetworkInternal003.internalMethod00033(stringArray[0])));
                }
            }
        }

        public List<String> internalMethod05178(String string) {
            return this.internalField0416.stream().filter(nestedValue0170 -> nestedValue0170.internalMethod03387().equals(string)).map(InternalType0483::internalMethod06545).filter(Objects::nonNull).collect(Collectors.toList());
        }

        public Optional<String> internalMethod06443(String string) {
            return this.internalField0416.stream().filter(nestedValue0170 -> nestedValue0170.internalMethod03387().equals(string)).map(InternalType0483::internalMethod06545).filter(Objects::nonNull).findFirst();
        }

        public boolean internalMethod07649(String string) {
            return this.internalField0416.stream().anyMatch(nestedValue0170 -> nestedValue0170.internalMethod03387().equals(string));
        }

        public InternalType0484 internalMethod06305(String string, @Nullable String string2) {
            this.internalField0416.add(new InternalType0483(string, string2));
            return this;
        }

        public InternalType0484 internalMethod05185(InternalType0483 nestedValue0170) {
            this.internalField0416.add(nestedValue0170);
            return this;
        }

        public InternalType0484 internalMethod05097(Iterable<InternalType0483> iterable) {
            iterable.forEach(this.internalField0416::add);
            return this;
        }

        public InternalType0484 internalMethod06358(InternalType0483[] nestedValue0171) {
            Collections.addAll(this.internalField0416, nestedValue0171);
            return this;
        }

        public InternalType0484 internalMethod01498(Map<String, String> map) {
            map.forEach((string, string2) -> this.internalField0416.add(new InternalType0483((String)string, (String)string2)));
            return this;
        }

        public InternalType0484 internalMethod00443(String string, @Nullable String string2) {
            this.internalField0416.removeIf(nestedValue0170 -> nestedValue0170.internalMethod03387().equals(string));
            this.internalField0416.add(new InternalType0483(string, string2));
            return this;
        }

        public InternalType0484 internalMethod04124(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.internalMethod00443(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public InternalType0484 internalMethod00279(String string) {
            this.internalField0416.removeIf(nestedValue0170 -> nestedValue0170.internalMethod03387().equals(string));
            return this;
        }

        public InternalType0484 internalMethod00861() {
            this.internalField0416.clear();
            return this;
        }

        public NetworkInternal004 internalMethod06913() {
            StringBuilder stringBuilder = new StringBuilder();
            for (InternalType0483 nestedValue0170 : this.internalField0416) {
                stringBuilder.append(NetworkInternal003.internalMethod06697(nestedValue0170.internalMethod03387()));
                if (nestedValue0170.internalMethod06545() != null) {
                    stringBuilder.append("=").append(NetworkInternal003.internalMethod06697(nestedValue0170.internalMethod06545()));
                }
                stringBuilder.append("&");
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            NetworkInternal004.this.internalMethod09626(stringBuilder.toString());
            return NetworkInternal004.this;
        }

        @Generated
        public List<InternalType0483> internalMethod00119() {
            return this.internalField0416;
        }
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public class InternalType0365 {
        private final Map<String, String> internalField0543 = new HashMap<String, String>();

        private InternalType0365() {
            String string = NetworkInternal004.this.internalMethod07894();
            if (string != null && !string.isEmpty()) {
                for (String string2 : string.split("&")) {
                    String[] stringArray = string2.split("=", 2);
                    if (stringArray.length == 2) {
                        this.internalField0543.put(NetworkInternal003.internalMethod00033(stringArray[0]), NetworkInternal003.internalMethod00033(stringArray[1]));
                        continue;
                    }
                    this.internalField0543.put(NetworkInternal003.internalMethod00033(stringArray[0]), "");
                }
            }
        }

        public Map<String, String> internalMethod00280() {
            return Collections.unmodifiableMap(this.internalField0543);
        }

        public Optional<String> internalMethod06119(String string) {
            return Optional.ofNullable(this.internalField0543.get(string));
        }

        public InternalType0365 internalMethod01433(String string, String string2) {
            this.internalField0543.put(string, string2);
            return this;
        }

        public InternalType0365 internalMethod03218(Map<String, String> map) {
            this.internalField0543.putAll(map);
            return this;
        }

        public InternalType0365 internalMethod03559(String string) {
            this.internalField0543.remove(string);
            return this;
        }

        public boolean internalMethod03794(String string) {
            return this.internalField0543.containsKey(string);
        }

        public NetworkInternal004 internalMethod06774() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : this.internalField0543.entrySet()) {
                stringBuilder.append(NetworkInternal003.internalMethod06697(entry.getKey())).append("=").append(NetworkInternal003.internalMethod06697(entry.getValue())).append("&");
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            NetworkInternal004.this.internalMethod09626(stringBuilder.toString());
            return NetworkInternal004.this;
        }

        public NetworkInternal004 internalMethod07582() {
            return NetworkInternal004.this;
        }
    }
}

