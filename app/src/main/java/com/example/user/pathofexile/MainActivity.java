package com.example.user.pathofexile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;

    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);

        new GetContacts().execute();
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "http://nikita.hackeruweb.co.il/hackDroid/items.json";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject("{\n" +
                            "\"total\": 72465,\n" +
                            "\"max_score\": 1,\n" +
                            "\"hits\": [\n" +
                            "{\n" +
                            "\"_index\": \"poe01\",\n" +
                            "\"_type\": \"item\",\n" +
                            "\"_id\": \"5b0548a5005e4e25c61d663d4a8c036db35ab68dbd8c7d882abda5d9cebb1a3b\",\n" +
                            "\"_score\": 1,\n" +
                            "\"_source\": {\n" +
                            "\"shop\": {\n" +
                            "\"hasPrice\": true,\n" +
                            "\"added\": 1472856127000,\n" +
                            "\"price\": {\n" +
                            "\"Orb of Fusing\": 11\n" +
                            "},\n" +
                            "\"priceSource\": \"stashName\",\n" +
                            "\"updated\": 1472856127000,\n" +
                            "\"chaosEquiv\": 5.5,\n" +
                            "\"sellerAccount\": \"InsaneWallaby\",\n" +
                            "\"verified\": \"YES\",\n" +
                            "\"modified\": 1472856127000,\n" +
                            "\"lastCharacterName\": \"Fiona_Falconstrike\",\n" +
                            "\"saleType\": \"b/o\",\n" +
                            "\"currency\": \"Orb of Fusing\",\n" +
                            "\"amount\": \"11\",\n" +
                            "\"stash\": {\n" +
                            "\"stashName\": \"~b/o 11 fuse\",\n" +
                            "\"yLocation\": \"8\",\n" +
                            "\"xLocation\": \"0\",\n" +
                            "\"stashID\": \"19d2ccf2111d60195101e6b8164da489e74c58f900c4ed2a6cc7572e3af36c2f\",\n" +
                            "\"inventoryID\": \"Stash7---\"\n" +
                            "},\n" +
                            "\"defaultMessage\": \"@Fiona_Falconstrike I would like to buy your Foe Stinger Citadel Bow listed for 11 Orb of Fusing (League:Standard, Stash Tab:~b/o 11 fuse [x0,y8])\"\n" +
                            "},\n" +
                            "\"info\": {\n" +
                            "\"fullName\": \"Foe Stinger Citadel Bow\",\n" +
                            "\"typeLine\": \"Citadel Bow\",\n" +
                            "\"icon\": \"http://web.poecdn.com/image/Art/2DItems/Weapons/TwoHandWeapons/Bows/Bow3.png\",\n" +
                            "\"name\": \"Foe Stinger\",\n" +
                            "\"tokenized\": {\n" +
                            "\"fullName\": \"foe stinger citadel bow\"\n" +
                            "}\n" +
                            "},\n" +
                            "\"requirements\": {\n" +
                            "\"Dex\": 185,\n" +
                            "\"Level\": 58\n" +
                            "},\n" +
                            "\"attributes\": {\n" +
                            "\"inventoryWidth\": 2,\n" +
                            "\"ilvl\": 78,\n" +
                            "\"identified\": true,\n" +
                            "\"baseItemType\": \"Weapon\",\n" +
                            "\"itemType\": \"Bow\",\n" +
                            "\"frameType\": 2,\n" +
                            "\"league\": \"Standard\",\n" +
                            "\"weaponType\": \"Bow\",\n" +
                            "\"corrupted\": false,\n" +
                            "\"rarity\": \"Rare\",\n" +
                            "\"lockedToCharacter\": false,\n" +
                            "\"mirrored\": false,\n" +
                            "\"explicitModsCount\": 6,\n" +
                            "\"equipType\": \"Bow\",\n" +
                            "\"baseItemName\": \"Citadel Bow\",\n" +
                            "\"inventoryHeight\": 4\n" +
                            "},\n" +
                            "\"properties\": {\n" +
                            "\"Weapon\": {\n" +
                            "\"Elemental Damage\": {\n" +
                            "\"min\": 38,\n" +
                            "\"max\": 65,\n" +
                            "\"avg\": 51\n" +
                            "},\n" +
                            "\"Elemental DPS\": 63,\n" +
                            "\"Physical Damage\": \"65-198\",\n" +
                            "\"Cold Damage\": {\n" +
                            "\"max\": 65,\n" +
                            "\"min\": 38,\n" +
                            "\"avg\": 51\n" +
                            "},\n" +
                            "\"Critical Strike Chance\": \"7.92\",\n" +
                            "\"type\": {\n" +
                            "\"Bow\": true\n" +
                            "},\n" +
                            "\"Total DPS\": 63,\n" +
                            "\"Cold DPS\": 63,\n" +
                            "\"Attacks per Second\": \"1.25\",\n" +
                            "\"Total Damage\": {\n" +
                            "\"avg\": 51,\n" +
                            "\"min\": 38,\n" +
                            "\"max\": 65\n" +
                            "}\n" +
                            "}\n" +
                            "},\n" +
                            "\"uuid\": \"5b0548a5005e4e25c61d663d4a8c036db35ab68dbd8c7d882abda5d9cebb1a3b\",\n" +
                            "\"mods\": {\n" +
                            "\"Bow\": {\n" +
                            "\"explicit\": {\n" +
                            "\"Adds # to # Physical Damage\": {\n" +
                            "\"min\": 23,\n" +
                            "\"max\": 46,\n" +
                            "\"avg\": 34.5\n" +
                            "},\n" +
                            "\"#% increased Stun Duration on Enemies\": 12,\n" +
                            "\"#% increased Critical Strike Chance\": 32,\n" +
                            "\"+# to Accuracy Rating\": 56,\n" +
                            "\"Adds # to # Cold Damage\": {\n" +
                            "\"max\": 65,\n" +
                            "\"min\": 38,\n" +
                            "\"avg\": 51.5\n" +
                            "},\n" +
                            "\"#% increased Physical Damage\": 35\n" +
                            "}\n" +
                            "}\n" +
                            "},\n" +
                            "\"modsTotal\": {\n" +
                            "\"+# to Accuracy Rating\": 56,\n" +
                            "\"Adds # to # Cold Damage\": {\n" +
                            "\"max\": 65,\n" +
                            "\"min\": 38,\n" +
                            "\"avg\": 51.5\n" +
                            "},\n" +
                            "\"#% increased Physical Damage\": 35,\n" +
                            "\"Adds # to # Physical Damage\": {\n" +
                            "\"avg\": 34.5,\n" +
                            "\"min\": 23,\n" +
                            "\"max\": 46\n" +
                            "},\n" +
                            "\"#% increased Stun Duration on Enemies\": 12,\n" +
                            "\"#% increased Critical Strike Chance\": 32\n" +
                            "},\n" +
                            "\"sockets\": {\n" +
                            "\"largestLinkGroup\": 2,\n" +
                            "\"allSockets\": \"GG\",\n" +
                            "\"allSocketsGGG\": \"G-G\",\n" +
                            "\"sortedLinkGroup\": {\n" +
                            "\"0\": \"GG\"\n" +
                            "},\n" +
                            "\"allSocketsSorted\": \"GG\",\n" +
                            "\"totalGreen\": 2,\n" +
                            "\"socketCount\": 2\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            ",\n" +
                            "{\n" +
                            "\"_index\": \"poe01\",\n" +
                            "\"_type\": \"item\",\n" +
                            "\"_id\": \"5f3f04c86d76a619e32ae497b92d2c4d284ba8dda41dd612f8cefffeaf26e1a1\",\n" +
                            "\"_score\": 1,\n" +
                            "\"_source\": {\n" +
                            "\"shop\": {\n" +
                            "\"verified\": \"YES\",\n" +
                            "\"modified\": 1472856129000,\n" +
                            "\"lastCharacterName\": \"XLTomato\",\n" +
                            "\"saleType\": \"Offer\",\n" +
                            "\"stash\": {\n" +
                            "\"stashName\": \"Uniques\",\n" +
                            "\"yLocation\": 5,\n" +
                            "\"stashID\": \"26a7b86253374371d3f2abe788a239748f763ecbf34efbbf736c03db843293fb\",\n" +
                            "\"xLocation\": 4,\n" +
                            "\"inventoryID\": \"Stash9\"\n" +
                            "},\n" +
                            "\"hasPrice\": false,\n" +
                            "\"added\": 1472856129000,\n" +
                            "\"updated\": 1472856129000,\n" +
                            "\"sellerAccount\": \"XLTomato\"\n" +
                            "},\n" +
                            "\"info\": {\n" +
                            "\"typeLine\": \"Death Bow\",\n" +
                            "\"icon\": \"http://web.poecdn.com/image/Art/2DItems/Weapons/TwoHandWeapons/Bows/Deathsharp.png\",\n" +
                            "\"fullName\": \"Death's Harp Death Bow\",\n" +
                            "\"name\": \"Death's Harp\",\n" +
                            "\"flavourText\": \"The mournful music of the strings, The creaking arch, the arrow sings. A choking cry, a rattled breath, The Reaper's Song, the Harp of Death.\",\n" +
                            "\"tokenized\": {\n" +
                            "\"fullName\": \"death's harp death bow\",\n" +
                            "\"flavourText\": \"the mournful music of the strings, the creaking arch, the arrow sings. a choking cry, a rattled breath, the reaper's song, the harp of death.\"\n" +
                            "}\n" +
                            "},\n" +
                            "\"requirements\": {\n" +
                            "\"Level\": 32,\n" +
                            "\"Dex\": 107\n" +
                            "},\n" +
                            "\"attributes\": {\n" +
                            "\"lockedToCharacter\": false,\n" +
                            "\"equipType\": \"Bow\",\n" +
                            "\"explicitModsCount\": 4,\n" +
                            "\"mirrored\": false,\n" +
                            "\"baseItemName\": \"Death Bow\",\n" +
                            "\"inventoryHeight\": 4,\n" +
                            "\"identified\": true,\n" +
                            "\"ilvl\": 69,\n" +
                            "\"baseItemType\": \"Weapon\",\n" +
                            "\"inventoryWidth\": 2,\n" +
                            "\"itemType\": \"Bow\",\n" +
                            "\"frameType\": 3,\n" +
                            "\"implicitModsCount\": 1,\n" +
                            "\"rarity\": \"Unique\",\n" +
                            "\"weaponType\": \"Bow\",\n" +
                            "\"league\": \"Standard\",\n" +
                            "\"corrupted\": true\n" +
                            "},\n" +
                            "\"properties\": {\n" +
                            "\"Weapon\": {\n" +
                            "\"Critical Strike Chance\": \"6.8\",\n" +
                            "\"type\": {\n" +
                            "\"Bow\": true\n" +
                            "},\n" +
                            "\"Physical Damage\": \"46-122\",\n" +
                            "\"Attacks per Second\": \"1.32\"\n" +
                            "},\n" +
                            "\"Quality\": \"20\"\n" +
                            "},\n" +
                            "\"uuid\": \"5f3f04c86d76a619e32ae497b92d2c4d284ba8dda41dd612f8cefffeaf26e1a1\",\n" +
                            "\"mods\": {\n" +
                            "\"Bow\": {\n" +
                            "\"implicit\": {\n" +
                            "\"#% increased Critical Strike Chance\": 36\n" +
                            "},\n" +
                            "\"explicit\": {\n" +
                            "\"+#% to Global Critical Strike Multiplier\": 100,\n" +
                            "\"Adds an additional Arrow\": true,\n" +
                            "\"#% increased Attack Speed\": 10,\n" +
                            "\"#% increased Physical Damage\": 110\n" +
                            "}\n" +
                            "}\n" +
                            "},\n" +
                            "\"modsTotal\": {\n" +
                            "\"#% increased Critical Strike Chance\": 36,\n" +
                            "\"+#% to Global Critical Strike Multiplier\": 100,\n" +
                            "\"#% increased Attack Speed\": 10,\n" +
                            "\"#% increased Physical Damage\": 110\n" +
                            "},\n" +
                            "\"sockets\": {\n" +
                            "\"allSockets\": \"GGGG-G\",\n" +
                            "\"largestLinkGroup\": 4,\n" +
                            "\"allSocketsGGG\": \"G-G-G-G G\",\n" +
                            "\"sortedLinkGroup\": {\n" +
                            "\"0\": \"GGGG\",\n" +
                            "\"1\": \"G\"\n" +
                            "},\n" +
                            "\"allSocketsSorted\": \"GGGGG\",\n" +
                            "\"totalGreen\": 5,\n" +
                            "\"socketCount\": 5\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            ",\n" +
                            "{\n" +
                            "\"_index\": \"poe01\",\n" +
                            "\"_type\": \"item\",\n" +
                            "\"_id\": \"75a94413e581a0acce6f25c4d90589cc7d523b2370f9b2794da58f80c127337e\",\n" +
                            "\"_score\": 1,\n" +
                            "\"_source\": {\n" +
                            "\"modsTotal\": {\n" +
                            "\"#% increased Physical Damage\": 118,\n" +
                            "\"+# Mana gained on Kill\": 2,\n" +
                            "\"+# to Accuracy Rating\": 236,\n" +
                            "\"+# Life gained on Kill\": 5,\n" +
                            "\"Adds # to # Lightning Damage\": {\n" +
                            "\"avg\": 27.5,\n" +
                            "\"min\": 3,\n" +
                            "\"max\": 52\n" +
                            "},\n" +
                            "\"Adds # to # Physical Damage\": {\n" +
                            "\"max\": 26,\n" +
                            "\"min\": 14,\n" +
                            "\"avg\": 20\n" +
                            "}\n" +
                            "},\n" +
                            "\"sockets\": {\n" +
                            "\"totalGreen\": 3,\n" +
                            "\"totalRed\": 1,\n" +
                            "\"socketCount\": 4,\n" +
                            "\"allSocketsSorted\": \"GGGR\",\n" +
                            "\"sortedLinkGroup\": {\n" +
                            "\"0\": \"GGGR\"\n" +
                            "},\n" +
                            "\"allSocketsGGG\": \"G-G-R-G\",\n" +
                            "\"allSockets\": \"GGRG\",\n" +
                            "\"largestLinkGroup\": 4\n" +
                            "},\n" +
                            "\"uuid\": \"75a94413e581a0acce6f25c4d90589cc7d523b2370f9b2794da58f80c127337e\",\n" +
                            "\"mods\": {\n" +
                            "\"Bow\": {\n" +
                            "\"explicit\": {\n" +
                            "\"Adds # to # Lightning Damage\": {\n" +
                            "\"avg\": 27.5,\n" +
                            "\"max\": 52,\n" +
                            "\"min\": 3\n" +
                            "},\n" +
                            "\"Adds # to # Physical Damage\": {\n" +
                            "\"min\": 14,\n" +
                            "\"max\": 26,\n" +
                            "\"avg\": 20\n" +
                            "},\n" +
                            "\"+# Life gained on Kill\": 5,\n" +
                            "\"+# Mana gained on Kill\": 2,\n" +
                            "\"+# to Accuracy Rating\": 236,\n" +
                            "\"#% increased Physical Damage\": 118\n" +
                            "}\n" +
                            "}\n" +
                            "},\n" +
                            "\"properties\": {\n" +
                            "\"Quality\": \"20\",\n" +
                            "\"Weapon\": {\n" +
                            "\"Lightning DPS\": 32,\n" +
                            "\"Attacks per Second\": \"1.2\",\n" +
                            "\"Total Damage\": {\n" +
                            "\"avg\": 27,\n" +
                            "\"min\": 3,\n" +
                            "\"max\": 52\n" +
                            "},\n" +
                            "\"Elemental Damage\": {\n" +
                            "\"avg\": 27,\n" +
                            "\"min\": 3,\n" +
                            "\"max\": 52\n" +
                            "},\n" +
                            "\"Elemental DPS\": 32,\n" +
                            "\"Physical Damage\": \"107-255\",\n" +
                            "\"type\": {\n" +
                            "\"Bow\": true\n" +
                            "},\n" +
                            "\"Critical Strike Chance\": \"5\",\n" +
                            "\"Lightning Damage\": {\n" +
                            "\"max\": 52,\n" +
                            "\"min\": 3,\n" +
                            "\"avg\": 27\n" +
                            "},\n" +
                            "\"Total DPS\": 32\n" +
                            "}\n" +
                            "},\n" +
                            "\"attributes\": {\n" +
                            "\"rarity\": \"Rare\",\n" +
                            "\"weaponType\": \"Bow\",\n" +
                            "\"league\": \"Standard\",\n" +
                            "\"corrupted\": false,\n" +
                            "\"frameType\": 2,\n" +
                            "\"itemType\": \"Bow\",\n" +
                            "\"ilvl\": 53,\n" +
                            "\"baseItemType\": \"Weapon\",\n" +
                            "\"identified\": true,\n" +
                            "\"inventoryWidth\": 2,\n" +
                            "\"inventoryHeight\": 4,\n" +
                            "\"baseItemName\": \"Decimation Bow\",\n" +
                            "\"explicitModsCount\": 6,\n" +
                            "\"mirrored\": false,\n" +
                            "\"equipType\": \"Bow\",\n" +
                            "\"lockedToCharacter\": false\n" +
                            "},\n" +
                            "\"requirements\": {\n" +
                            "\"Dex\": 170,\n" +
                            "\"Level\": 53\n" +
                            "},\n" +
                            "\"info\": {\n" +
                            "\"typeLine\": \"Decimation Bow\",\n" +
                            "\"icon\": \"http://web.poecdn.com/image/Art/2DItems/Weapons/TwoHandWeapons/Bows/Bow8.png\",\n" +
                            "\"fullName\": \"Brood Nock Decimation Bow\",\n" +
                            "\"name\": \"Brood Nock\",\n" +
                            "\"tokenized\": {\n" +
                            "\"fullName\": \"brood nock decimation bow\"\n" +
                            "}\n" +
                            "},\n" +
                            "\"shop\": {\n" +
                            "\"modified\": 1472856131000,\n" +
                            "\"verified\": \"YES\",\n" +
                            "\"currency\": \"Chaos Orb\",\n" +
                            "\"saleType\": \"b/o\",\n" +
                            "\"lastCharacterName\": \"SoupDweller\",\n" +
                            "\"defaultMessage\": \"@SoupDweller I would like to buy your Brood Nock Decimation Bow listed for 10 Chaos Orb (League:Standard, Stash Tab:~b/o 10 chaos [x0,y0])\",\n" +
                            "\"stash\": {\n" +
                            "\"xLocation\": \"0\",\n" +
                            "\"stashID\": \"18959e777d45796d4c0d16c7e84a9070f825956eb5dfdb35c659b031c3c74dd5\",\n" +
                            "\"inventoryID\": \"Stash1\",\n" +
                            "\"stashName\": \"~b/o 10 chaos\",\n" +
                            "\"yLocation\": \"0\"\n" +
                            "},\n" +
                            "\"amount\": \"10\",\n" +
                            "\"hasPrice\": true,\n" +
                            "\"priceSource\": \"stashName\",\n" +
                            "\"price\": {\n" +
                            "\"Chaos Orb\": 10\n" +
                            "},\n" +
                            "\"added\": 1472856131000,\n" +
                            "\"updated\": 1472856131000,\n" +
                            "\"sellerAccount\": \"ProfessorObb\",\n" +
                            "\"chaosEquiv\": 10\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            ",\n" +
                            "{\n" +
                            "\"_index\": \"poe01\",\n" +
                            "\"_type\": \"item\",\n" +
                            "\"_id\": \"7bcd95c48ad083c748a03f573eb697e948a5ef1d5402e37896a8299819ce4443\",\n" +
                            "\"_score\": 1,\n" +
                            "\"_source\": {\n" +
                            "\"mods\": {\n" +
                            "\"Bow\": {\n" +
                            "\"explicit\": {\n" +
                            "\"No Physical Damage\": true,\n" +
                            "\"Adds # to # Lightning Damage\": {\n" +
                            "\"max\": 85,\n" +
                            "\"avg\": 43,\n" +
                            "\"min\": 1\n" +
                            "},\n" +
                            "\"#% increased Attack Speed\": 49\n" +
                            "}\n" +
                            "}\n" +
                            "},\n" +
                            "\"info\": {\n" +
                            "\"icon\": \"http://web.poecdn.com/image/Art/2DItems/Weapons/TwoHandWeapons/Bows/Stormcloud.png\",\n" +
                            "\"flavourText\": \"Centuries of development in steel armoursmithing turned the armies of the Eternal Empire into very effective lightning rods.\",\n" +
                            "\"fullName\": \"Storm Cloud Long Bow\",\n" +
                            "\"name\": \"Storm Cloud\",\n" +
                            "\"tokenized\": {\n" +
                            "\"fullName\": \"storm cloud long bow\",\n" +
                            "\"flavourText\": \"centuries of development in steel armoursmithing turned the armies of the eternal empire into very effective lightning rods.\"\n" +
                            "},\n" +
                            "\"typeLine\": \"Long Bow\"\n" +
                            "},\n" +
                            "\"sockets\": {\n" +
                            "\"allSocketsSorted\": \"GGR\",\n" +
                            "\"largestLinkGroup\": 3,\n" +
                            "\"totalGreen\": 2,\n" +
                            "\"sortedLinkGroup\": {\n" +
                            "\"0\": \"GGR\"\n" +
                            "},\n" +
                            "\"totalRed\": 1,\n" +
                            "\"allSocketsGGG\": \"G-G-R\",\n" +
                            "\"socketCount\": 3,\n" +
                            "\"allSockets\": \"GGR\"\n" +
                            "},\n" +
                            "\"modsTotal\": {\n" +
                            "\"#% increased Attack Speed\": 49,\n" +
                            "\"Adds # to # Lightning Damage\": {\n" +
                            "\"min\": 1,\n" +
                            "\"avg\": 43,\n" +
                            "\"max\": 85\n" +
                            "}\n" +
                            "},\n" +
                            "\"shop\": {\n" +
                            "\"verified\": \"YES\",\n" +
                            "\"added\": 1472856132000,\n" +
                            "\"lastCharacterName\": \"StrongMemeGame\",\n" +
                            "\"stash\": {\n" +
                            "\"stashName\": \"Expensive Uniques\",\n" +
                            "\"yLocation\": 4,\n" +
                            "\"stashID\": \"0d4c01b1166c79cd8cd922f7fa85595562cdbd775c6ba51a849594c9e9b53051\",\n" +
                            "\"inventoryID\": \"Stash8\",\n" +
                            "\"xLocation\": 2\n" +
                            "},\n" +
                            "\"sellerAccount\": \"Figjam\",\n" +
                            "\"modified\": 1472856132000,\n" +
                            "\"hasPrice\": false,\n" +
                            "\"updated\": 1472856132000,\n" +
                            "\"saleType\": \"Offer\"\n" +
                            "},\n" +
                            "\"uuid\": \"7bcd95c48ad083c748a03f573eb697e948a5ef1d5402e37896a8299819ce4443\",\n" +
                            "\"properties\": {\n" +
                            "\"Weapon\": {\n" +
                            "\"Elemental DPS\": 83,\n" +
                            "\"Total DPS\": 83,\n" +
                            "\"Attacks per Second\": \"1.94\",\n" +
                            "\"type\": {\n" +
                            "\"Bow\": true\n" +
                            "},\n" +
                            "\"Total Damage\": {\n" +
                            "\"avg\": 43,\n" +
                            "\"min\": 1,\n" +
                            "\"max\": 85\n" +
                            "},\n" +
                            "\"Lightning Damage\": {\n" +
                            "\"max\": 85,\n" +
                            "\"min\": 1,\n" +
                            "\"avg\": 43\n" +
                            "},\n" +
                            "\"Critical Strike Chance\": \"6\",\n" +
                            "\"Elemental Damage\": {\n" +
                            "\"max\": 85,\n" +
                            "\"min\": 1,\n" +
                            "\"avg\": 43\n" +
                            "},\n" +
                            "\"Lightning DPS\": 83\n" +
                            "}\n" +
                            "},\n" +
                            "\"attributes\": {\n" +
                            "\"inventoryWidth\": 2,\n" +
                            "\"mirrored\": false,\n" +
                            "\"weaponType\": \"Bow\",\n" +
                            "\"baseItemType\": \"Weapon\",\n" +
                            "\"baseItemName\": \"Long Bow\",\n" +
                            "\"identified\": true,\n" +
                            "\"itemType\": \"Bow\",\n" +
                            "\"equipType\": \"Bow\",\n" +
                            "\"lockedToCharacter\": false,\n" +
                            "\"inventoryHeight\": 4,\n" +
                            "\"frameType\": 3,\n" +
                            "\"corrupted\": false,\n" +
                            "\"league\": \"Standard\",\n" +
                            "\"ilvl\": 75,\n" +
                            "\"explicitModsCount\": 3,\n" +
                            "\"rarity\": \"Unique\"\n" +
                            "},\n" +
                            "\"requirements\": {\n" +
                            "\"Level\": 9,\n" +
                            "\"Dex\": 38\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            ",\n" +
                            "{\n" +
                            "\"_index\": \"poe01\",\n" +
                            "\"_type\": \"item\",\n" +
                            "\"_id\": \"e6394a29b76b2aa3997b4440852d66543b3a5d820539a675f99822e27a4a9537\",\n" +
                            "\"_score\": 1,\n" +
                            "\"_source\": {\n" +
                            "\"info\": {\n" +
                            "\"fullName\": \"Remora's Harbinger Bow of the Zephyr\",\n" +
                            "\"tokenized\": {\n" +
                            "\"fullName\": \"remora's harbinger bow of the zephyr\"\n" +
                            "},\n" +
                            "\"typeLine\": \"Remora's Harbinger Bow of the Zephyr\",\n" +
                            "\"icon\": \"http://web.poecdn.com/image/Art/2DItems/Weapons/TwoHandWeapons/Bows/Bow8.png\"\n" +
                            "},\n" +
                            "\"mods\": {\n" +
                            "\"Bow\": {\n" +
                            "\"implicit\": {\n" +
                            "\"#% increased Critical Strike Chance\": 48\n" +
                            "},\n" +
                            "\"explicit\": {\n" +
                            "\"#% of Physical Attack Damage Leeched as Life\": 0.21,\n" +
                            "\"#% increased Projectile Speed\": 34\n" +
                            "}\n" +
                            "}\n" +
                            "},\n" +
                            "\"modsTotal\": {\n" +
                            "\"#% increased Projectile Speed\": 34,\n" +
                            "\"#% of Physical Attack Damage Leeched as Life\": 0.21,\n" +
                            "\"#% increased Critical Strike Chance\": 48\n" +
                            "},\n" +
                            "\"sockets\": {\n" +
                            "\"sortedLinkGroup\": {\n" +
                            "\"0\": \"GGG\",\n" +
                            "\"1\": \"GG\",\n" +
                            "\"2\": \"G\"\n" +
                            "},\n" +
                            "\"allSockets\": \"GGG-GG-G\",\n" +
                            "\"totalGreen\": 6,\n" +
                            "\"largestLinkGroup\": 3,\n" +
                            "\"allSocketsSorted\": \"GGGGGG\",\n" +
                            "\"socketCount\": 6,\n" +
                            "\"allSocketsGGG\": \"G-G-G G-G G\"\n" +
                            "},\n" +
                            "\"uuid\": \"e6394a29b76b2aa3997b4440852d66543b3a5d820539a675f99822e27a4a9537\",\n" +
                            "\"shop\": {\n" +
                            "\"chaosEquiv\": 5,\n" +
                            "\"currency\": \"Orb of Fusing\",\n" +
                            "\"added\": 1472856133000,\n" +
                            "\"verified\": \"YES\",\n" +
                            "\"defaultMessage\": \"@Fiona_Falconstrike I would like to buy your Remora's Harbinger Bow of the Zephyr listed for 10 Orb of Fusing (League:Standard, Stash Tab:~b/o 10 fuse [x10,y0])\",\n" +
                            "\"updated\": 1472856133000,\n" +
                            "\"amount\": \"10\",\n" +
                            "\"saleType\": \"b/o\",\n" +
                            "\"lastCharacterName\": \"Fiona_Falconstrike\",\n" +
                            "\"hasPrice\": true,\n" +
                            "\"modified\": 1472856133000,\n" +
                            "\"sellerAccount\": \"InsaneWallaby\",\n" +
                            "\"stash\": {\n" +
                            "\"stashID\": \"055c9a43a3f9359ff9f6949d26698caf9dfe56558ff8c8056e9fe4980b1807ef\",\n" +
                            "\"inventoryID\": \"Stash54\",\n" +
                            "\"xLocation\": \"10\",\n" +
                            "\"yLocation\": \"0\",\n" +
                            "\"stashName\": \"~b/o 10 fuse\"\n" +
                            "},\n" +
                            "\"price\": {\n" +
                            "\"Orb of Fusing\": 10\n" +
                            "},\n" +
                            "\"priceSource\": \"stashName\"\n" +
                            "},\n" +
                            "\"attributes\": {\n" +
                            "\"baseItemType\": \"Weapon\",\n" +
                            "\"implicitModsCount\": 1,\n" +
                            "\"mirrored\": false,\n" +
                            "\"weaponType\": \"Bow\",\n" +
                            "\"inventoryWidth\": 2,\n" +
                            "\"league\": \"Standard\",\n" +
                            "\"ilvl\": 69,\n" +
                            "\"rarity\": \"Magic\",\n" +
                            "\"explicitModsCount\": 2,\n" +
                            "\"inventoryHeight\": 4,\n" +
                            "\"corrupted\": false,\n" +
                            "\"frameType\": 1,\n" +
                            "\"lockedToCharacter\": false,\n" +
                            "\"baseItemName\": \"Harbinger Bow\",\n" +
                            "\"identified\": true,\n" +
                            "\"itemType\": \"Bow\",\n" +
                            "\"equipType\": \"Bow\"\n" +
                            "},\n" +
                            "\"requirements\": {\n" +
                            "\"Dex\": 212,\n" +
                            "\"Level\": 68\n" +
                            "},\n" +
                            "\"properties\": {\n" +
                            "\"Weapon\": {\n" +
                            "\"Attacks per Second\": \"1.2\",\n" +
                            "\"type\": {\n" +
                            "\"Bow\": true\n" +
                            "},\n" +
                            "\"Physical Damage\": \"35-91\",\n" +
                            "\"Critical Strike Chance\": \"7.4\"\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            ",\n" +
                            "{\n" +
                            "\"_index\": \"poe01\",\n" +
                            "\"_type\": \"item\",\n" +
                            "\"_id\": \"27e8042056616f6246de3935b4660bc8da5a7cfb742a054baf0d91eb71025923\",\n" +
                            "\"_score\": 1,\n" +
                            "\"_source\": {\n" +
                            "\"attributes\": {\n" +
                            "\"equipType\": \"Bow\",\n" +
                            "\"identified\": true,\n" +
                            "\"itemType\": \"Bow\",\n" +
                            "\"baseItemName\": \"Crude Bow\",\n" +
                            "\"lockedToCharacter\": false,\n" +
                            "\"frameType\": 3,\n" +
                            "\"corrupted\": false,\n" +
                            "\"inventoryHeight\": 3,\n" +
                            "\"rarity\": \"Unique\",\n" +
                            "\"explicitModsCount\": 5,\n" +
                            "\"league\": \"Hardcore\",\n" +
                            "\"ilvl\": 17,\n" +
                            "\"inventoryWidth\": 2,\n" +
                            "\"weaponType\": \"Bow\",\n" +
                            "\"mirrored\": false,\n" +
                            "\"baseItemType\": \"Weapon\"\n" +
                            "},\n" +
                            "\"properties\": {\n" +
                            "\"Weapon\": {\n" +
                            "\"Physical Damage\": \"9-23\",\n" +
                            "\"type\": {\n" +
                            "\"Bow\": true\n" +
                            "},\n" +
                            "\"Attacks per Second\": \"1.54\",\n" +
                            "\"Critical Strike Chance\": \"5\"\n" +
                            "}\n" +
                            "},\n" +
                            "\"uuid\": \"27e8042056616f6246de3935b4660bc8da5a7cfb742a054baf0d91eb71025923\",\n" +
                            "\"shop\": {\n" +
                            "\"added\": 1472856134000,\n" +
                            "\"verified\": \"YES\",\n" +
                            "\"updated\": 1472856134000,\n" +
                            "\"saleType\": \"Offer\",\n" +
                            "\"lastCharacterName\": \"morlox\",\n" +
                            "\"stash\": {\n" +
                            "\"yLocation\": 3,\n" +
                            "\"xLocation\": 1,\n" +
                            "\"inventoryID\": \"Stash45\",\n" +
                            "\"stashID\": \"51db6509b3b0405de18a69c0de07d187da507a3bc1fdfda8dd47a516ee7c84df\",\n" +
                            "\"stashName\": \"641 lowlevelgg\"\n" +
                            "},\n" +
                            "\"sellerAccount\": \"morloxIC\",\n" +
                            "\"hasPrice\": false,\n" +
                            "\"modified\": 1472856134000\n" +
                            "},\n" +
                            "\"modsTotal\": {\n" +
                            "\"+# to Accuracy Rating\": 30,\n" +
                            "\"#% increased Attack Speed\": 10,\n" +
                            "\"#% increased Physical Damage\": 74,\n" +
                            "\"+# to Level of Socketed Bow Gems\": 1,\n" +
                            "\"+# Mana gained on Kill\": 10\n" +
                            "},\n" +
                            "\"sockets\": {\n" +
                            "\"socketCount\": 1,\n" +
                            "\"allSocketsGGG\": \"B\",\n" +
                            "\"largestLinkGroup\": 1,\n" +
                            "\"allSocketsSorted\": \"B\",\n" +
                            "\"totalBlue\": 1,\n" +
                            "\"sortedLinkGroup\": {\n" +
                            "\"0\": \"B\"\n" +
                            "},\n" +
                            "\"allSockets\": \"B\"\n" +
                            "},\n" +
                            "\"info\": {\n" +
                            "\"tokenized\": {\n" +
                            "\"flavourText\": \"the wild takes care of its own. - hyrri of the karui\",\n" +
                            "\"fullName\": \"silverbranch crude bow\"\n" +
                            "},\n" +
                            "\"typeLine\": \"Crude Bow\",\n" +
                            "\"name\": \"Silverbranch\",\n" +
                            "\"fullName\": \"Silverbranch Crude Bow\",\n" +
                            "\"flavourText\": \"The wild takes care of its own. - Hyrri of the Karui\",\n" +
                            "\"icon\": \"http://web.poecdn.com/image/Art/2DItems/Weapons/TwoHandWeapons/Bows/Bow1Unique.png\"\n" +
                            "},\n" +
                            "\"mods\": {\n" +
                            "\"Bow\": {\n" +
                            "\"explicit\": {\n" +
                            "\"+# to Accuracy Rating\": 30,\n" +
                            "\"#% increased Attack Speed\": 10,\n" +
                            "\"#% increased Physical Damage\": 74,\n" +
                            "\"+# to Level of Socketed Bow Gems\": 1,\n" +
                            "\"+# Mana gained on Kill\": 10\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            ",\n" +
                            "{\n" +
                            "\"_index\": \"poe01\",\n" +
                            "\"_type\": \"item\",\n" +
                            "\"_id\": \"e7577d3f5e04cc9651d33d2f03df389f38239dce2d2a9b3347260ea5d81bb5d6\",\n" +
                            "\"_score\": 1,\n" +
                            "\"_source\": {\n" +
                            "\"attributes\": {\n" +
                            "\"league\": \"Standard\",\n" +
                            "\"identified\": true,\n" +
                            "\"explicitModsCount\": 4,\n" +
                            "\"weaponType\": \"Bow\",\n" +
                            "\"baseItemName\": \"Death Bow\",\n" +
                            "\"inventoryHeight\": 4,\n" +
                            "\"corrupted\": false,\n" +
                            "\"ilvl\": 67,\n" +
                            "\"baseItemType\": \"Weapon\",\n" +
                            "\"rarity\": \"Unique\",\n" +
                            "\"lockedToCharacter\": false,\n" +
                            "\"equipType\": \"Bow\",\n" +
                            "\"frameType\": 3,\n" +
                            "\"inventoryWidth\": 2,\n" +
                            "\"mirrored\": false,\n" +
                            "\"itemType\": \"Bow\"\n" +
                            "},\n" +
                            "\"mods\": {\n" +
                            "\"Bow\": {\n" +
                            "\"explicit\": {\n" +
                            "\"Adds an additional Arrow\": true,\n" +
                            "\"#% increased Attack Speed\": 10,\n" +
                            "\"+#% to Global Critical Strike Multiplier\": 100,\n" +
                            "\"#% increased Physical Damage\": 102\n" +
                            "}\n" +
                            "}\n" +
                            "},\n" +
                            "\"info\": {\n" +
                            "\"typeLine\": \"Death Bow\",\n" +
                            "\"flavourText\": \"The mournful music of the strings, The creaking arch, the arrow sings. A choking cry, a rattled breath, The Reaper's Song, the Harp of Death.\",\n" +
                            "\"fullName\": \"Death's Harp Death Bow\",\n" +
                            "\"tokenized\": {\n" +
                            "\"fullName\": \"death's harp death bow\",\n" +
                            "\"flavourText\": \"the mournful music of the strings, the creaking arch, the arrow sings. a choking cry, a rattled breath, the reaper's song, the harp of death.\"\n" +
                            "},\n" +
                            "\"icon\": \"http://web.poecdn.com/image/Art/2DItems/Weapons/TwoHandWeapons/Bows/Deathsharp.png\",\n" +
                            "\"name\": \"Death's Harp\"\n" +
                            "},\n" +
                            "\"requirements\": {\n" +
                            "\"Level\": 32,\n" +
                            "\"Dex\": 107\n" +
                            "},\n" +
                            "\"modsTotal\": {\n" +
                            "\"#% increased Attack Speed\": 10,\n" +
                            "\"+#% to Global Critical Strike Multiplier\": 100,\n" +
                            "\"#% increased Physical Damage\": 102\n" +
                            "},\n" +
                            "\"properties\": {\n" +
                            "\"Quality\": \"20\",\n" +
                            "\"Weapon\": {\n" +
                            "\"Attacks per Second\": \"1.32\",\n" +
                            "\"Physical Damage\": \"44-118\",\n" +
                            "\"type\": {\n" +
                            "\"Bow\": true\n" +
                            "},\n" +
                            "\"Critical Strike Chance\": \"5\"\n" +
                            "}\n" +
                            "},\n" +
                            "\"shop\": {\n" +
                            "\"lastCharacterName\": \"MeBamBam\",\n" +
                            "\"added\": 1472856135000,\n" +
                            "\"hasPrice\": false,\n" +
                            "\"saleType\": \"Offer\",\n" +
                            "\"updated\": 1472856135000,\n" +
                            "\"verified\": \"YES\",\n" +
                            "\"sellerAccount\": \"ratelaar\",\n" +
                            "\"modified\": 1472856135000,\n" +
                            "\"stash\": {\n" +
                            "\"inventoryID\": \"Stash2\",\n" +
                            "\"yLocation\": 8,\n" +
                            "\"stashID\": \"171c7f66ceec77e74525dd6d929ab8fd81cd026e98d72b23b3ed6c1525c56ea2\",\n" +
                            "\"stashName\": \"10\",\n" +
                            "\"xLocation\": 4\n" +
                            "}\n" +
                            "},\n" +
                            "\"sockets\": {\n" +
                            "\"allSocketsGGG\": \"G-G-G\",\n" +
                            "\"sortedLinkGroup\": {\n" +
                            "\"0\": \"GGG\"\n" +
                            "},\n" +
                            "\"largestLinkGroup\": 3,\n" +
                            "\"allSocketsSorted\": \"GGG\",\n" +
                            "\"totalGreen\": 3,\n" +
                            "\"socketCount\": 3,\n" +
                            "\"allSockets\": \"GGG\"\n" +
                            "},\n" +
                            "\"uuid\": \"e7577d3f5e04cc9651d33d2f03df389f38239dce2d2a9b3347260ea5d81bb5d6\"\n" +
                            "}\n" +
                            "}\n" +
                            ",\n" +
                            "{\n" +
                            "\"_index\": \"poe01\",\n" +
                            "\"_type\": \"item\",\n" +
                            "\"_id\": \"5b368b82c3d9c56b14bb988cc26a4c4dfdb651846691c4e357f5e5933f640476\",\n" +
                            "\"_score\": 1,\n" +
                            "\"_source\": {\n" +
                            "\"uuid\": \"5b368b82c3d9c56b14bb988cc26a4c4dfdb651846691c4e357f5e5933f640476\",\n" +
                            "\"requirements\": {\n" +
                            "\"Level\": 59,\n" +
                            "\"Dex\": 179\n" +
                            "},\n" +
                            "\"sockets\": {\n" +
                            "\"allSocketsGGG\": \"G B B-G\",\n" +
                            "\"socketCount\": 4,\n" +
                            "\"sortedLinkGroup\": {\n" +
                            "\"0\": \"G\",\n" +
                            "\"1\": \"B\",\n" +
                            "\"2\": \"BG\"\n" +
                            "},\n" +
                            "\"allSocketsSorted\": \"BBGG\",\n" +
                            "\"totalBlue\": 2,\n" +
                            "\"allSockets\": \"G-B-BG\",\n" +
                            "\"largestLinkGroup\": 2,\n" +
                            "\"totalGreen\": 2\n" +
                            "},\n" +
                            "\"mods\": {\n" +
                            "\"Bow\": {\n" +
                            "\"explicit\": {\n" +
                            "\"Adds # to # Fire Damage\": {\n" +
                            "\"max\": 56,\n" +
                            "\"avg\": 42.5,\n" +
                            "\"min\": 29\n" +
                            "},\n" +
                            "\"Adds # to # Cold Damage\": {\n" +
                            "\"max\": 15,\n" +
                            "\"avg\": 11.5,\n" +
                            "\"min\": 8\n" +
                            "},\n" +
                            "\"Adds # to # Lightning Damage\": {\n" +
                            "\"max\": 113,\n" +
                            "\"min\": 9,\n" +
                            "\"avg\": 61\n" +
                            "},\n" +
                            "\"#% increased Stun Duration on Enemies\": 13,\n" +
                            "\"+# Mana gained on Kill\": 1\n" +
                            "}\n" +
                            "}\n" +
                            "},\n" +
                            "\"attributes\": {\n" +
                            "\"weaponType\": \"Bow\",\n" +
                            "\"equipType\": \"Bow\",\n" +
                            "\"inventoryHeight\": 3,\n" +
                            "\"ilvl\": 77,\n" +
                            "\"rarity\": \"Rare\",\n" +
                            "\"baseItemType\": \"Weapon\",\n" +
                            "\"league\": \"Standard\",\n" +
                            "\"inventoryWidth\": 2,\n" +
                            "\"itemType\": \"Bow\",\n" +
                            "\"corrupted\": false,\n" +
                            "\"identified\": true,\n" +
                            "\"mirrored\": false,\n" +
                            "\"frameType\": 2,\n" +
                            "\"baseItemName\": \"Thicket Bow\",\n" +
                            "\"explicitModsCount\": 5,\n" +
                            "\"lockedToCharacter\": false\n" +
                            "},\n" +
                            "\"shop\": {\n" +
                            "\"updated\": 1472856063000,\n" +
                            "\"lastCharacterName\": \"Fiona_Falconstrike\",\n" +
                            "\"priceSource\": \"stashName\",\n" +
                            "\"sellerAccount\": \"InsaneWallaby\",\n" +
                            "\"saleType\": \"b/o\",\n" +
                            "\"price\": {\n" +
                            "\"Chaos Orb\": 12\n" +
                            "},\n" +
                            "\"verified\": \"YES\",\n" +
                            "\"hasPrice\": true,\n" +
                            "\"modified\": 1472856063000,\n" +
                            "\"chaosEquiv\": 12,\n" +
                            "\"currency\": \"Chaos Orb\",\n" +
                            "\"defaultMessage\": \"@Fiona_Falconstrike I would like to buy your Corruption Wing Thicket Bow listed for 12 Chaos Orb (League:Standard, Stash Tab:~b/o 12 chaos [x6,y0])\",\n" +
                            "\"added\": 1472856063000,\n" +
                            "\"stash\": {\n" +
                            "\"yLocation\": \"0\",\n" +
                            "\"inventoryID\": \"Stash26\",\n" +
                            "\"xLocation\": \"6\",\n" +
                            "\"stashName\": \"~b/o 12 chaos\",\n" +
                            "\"stashID\": \"3a010ef1e559b990a139713149f151cda1688333a91ec3f699dff18ca160b732\"\n" +
                            "},\n" +
                            "\"amount\": \"12\"\n" +
                            "},\n" +
                            "\"info\": {\n" +
                            "\"tokenized\": {\n" +
                            "\"fullName\": \"corruption wing thicket bow\"\n" +
                            "},\n" +
                            "\"typeLine\": \"Thicket Bow\",\n" +
                            "\"fullName\": \"Corruption Wing Thicket Bow\",\n" +
                            "\"name\": \"Corruption Wing\",\n" +
                            "\"icon\": \"http://web.poecdn.com/image/Art/2DItems/Weapons/TwoHandWeapons/Bows/Bow2.png\"\n" +
                            "},\n" +
                            "\"properties\": {\n" +
                            "\"Weapon\": {\n" +
                            "\"type\": {\n" +
                            "\"Bow\": true\n" +
                            "},\n" +
                            "\"Total DPS\": 172,\n" +
                            "\"Lightning Damage\": {\n" +
                            "\"avg\": 61,\n" +
                            "\"min\": 9,\n" +
                            "\"max\": 113\n" +
                            "},\n" +
                            "\"Elemental DPS\": 172,\n" +
                            "\"Fire DPS\": 63,\n" +
                            "\"Cold Damage\": {\n" +
                            "\"min\": 8,\n" +
                            "\"avg\": 11,\n" +
                            "\"max\": 15\n" +
                            "},\n" +
                            "\"Total Damage\": {\n" +
                            "\"min\": 46,\n" +
                            "\"avg\": 115,\n" +
                            "\"max\": 184\n" +
                            "},\n" +
                            "\"Fire Damage\": {\n" +
                            "\"max\": 56,\n" +
                            "\"avg\": 42,\n" +
                            "\"min\": 29\n" +
                            "},\n" +
                            "\"Cold DPS\": 16,\n" +
                            "\"Attacks per Second\": \"1.5\",\n" +
                            "\"Critical Strike Chance\": \"5\",\n" +
                            "\"Lightning DPS\": 91,\n" +
                            "\"Physical Damage\": \"22-66\",\n" +
                            "\"Elemental Damage\": {\n" +
                            "\"max\": 184,\n" +
                            "\"min\": 46,\n" +
                            "\"avg\": 115\n" +
                            "}\n" +
                            "}\n" +
                            "},\n" +
                            "\"modsTotal\": {\n" +
                            "\"Adds # to # Cold Damage\": {\n" +
                            "\"min\": 8,\n" +
                            "\"avg\": 11.5,\n" +
                            "\"max\": 15\n" +
                            "},\n" +
                            "\"Adds # to # Fire Damage\": {\n" +
                            "\"max\": 56,\n" +
                            "\"min\": 29,\n" +
                            "\"avg\": 42.5\n" +
                            "},\n" +
                            "\"+# Mana gained on Kill\": 1,\n" +
                            "\"#% increased Stun Duration on Enemies\": 13,\n" +
                            "\"Adds # to # Lightning Damage\": {\n" +
                            "\"min\": 9,\n" +
                            "\"avg\": 61,\n" +
                            "\"max\": 113\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            ",\n" +
                            "{\n" +
                            "\"_index\": \"poe01\",\n" +
                            "\"_type\": \"item\",\n" +
                            "\"_id\": \"9cae5c157156fcf879f660a777d1a6071dee5ed52a477f9afda430453d327a28\",\n" +
                            "\"_score\": 1,\n" +
                            "\"_source\": {\n" +
                            "\"mods\": {\n" +
                            "\"Bow\": {\n" +
                            "\"implicit\": {\n" +
                            "\"#% increased Critical Strike Chance\": 33\n" +
                            "},\n" +
                            "\"explicit\": {\n" +
                            "\"#% increased Physical Damage\": 71,\n" +
                            "\"Adds # to # Fire Damage\": {\n" +
                            "\"min\": 14,\n" +
                            "\"avg\": 22,\n" +
                            "\"max\": 30\n" +
                            "},\n" +
                            "\"Adds # to # Physical Damage\": {\n" +
                            "\"max\": 24,\n" +
                            "\"min\": 13,\n" +
                            "\"avg\": 18.5\n" +
                            "},\n" +
                            "\"#% increased Projectile Speed\": 18\n" +
                            "}\n" +
                            "}\n" +
                            "},\n" +
                            "\"attributes\": {\n" +
                            "\"itemType\": \"Bow\",\n" +
                            "\"inventoryWidth\": 2,\n" +
                            "\"inventoryHeight\": 4,\n" +
                            "\"ilvl\": 69,\n" +
                            "\"rarity\": \"Rare\",\n" +
                            "\"baseItemType\": \"Weapon\",\n" +
                            "\"implicitModsCount\": 1,\n" +
                            "\"league\": \"Standard\",\n" +
                            "\"weaponType\": \"Bow\",\n" +
                            "\"equipType\": \"Bow\",\n" +
                            "\"baseItemName\": \"Decimation Bow\",\n" +
                            "\"explicitModsCount\": 4,\n" +
                            "\"lockedToCharacter\": false,\n" +
                            "\"mirrored\": false,\n" +
                            "\"frameType\": 2,\n" +
                            "\"corrupted\": false,\n" +
                            "\"identified\": true\n" +
                            "},\n" +
                            "\"sockets\": {\n" +
                            "\"socketCount\": 2,\n" +
                            "\"allSocketsSorted\": \"GG\",\n" +
                            "\"sortedLinkGroup\": {\n" +
                            "\"0\": \"G\",\n" +
                            "\"1\": \"G\"\n" +
                            "},\n" +
                            "\"allSockets\": \"G-G\",\n" +
                            "\"allSocketsGGG\": \"G G\",\n" +
                            "\"largestLinkGroup\": 1,\n" +
                            "\"totalGreen\": 2\n" +
                            "},\n" +
                            "\"requirements\": {\n" +
                            "\"Dex\": 170,\n" +
                            "\"Level\": 53\n" +
                            "},\n" +
                            "\"uuid\": \"9cae5c157156fcf879f660a777d1a6071dee5ed52a477f9afda430453d327a28\",\n" +
                            "\"modsTotal\": {\n" +
                            "\"Adds # to # Fire Damage\": {\n" +
                            "\"max\": 30,\n" +
                            "\"avg\": 22,\n" +
                            "\"min\": 14\n" +
                            "},\n" +
                            "\"#% increased Physical Damage\": 71,\n" +
                            "\"#% increased Critical Strike Chance\": 33,\n" +
                            "\"#% increased Projectile Speed\": 18,\n" +
                            "\"Adds # to # Physical Damage\": {\n" +
                            "\"max\": 24,\n" +
                            "\"min\": 13,\n" +
                            "\"avg\": 18.5\n" +
                            "}\n" +
                            "},\n" +
                            "\"properties\": {\n" +
                            "\"Weapon\": {\n" +
                            "\"Total DPS\": 26,\n" +
                            "\"type\": {\n" +
                            "\"Bow\": true\n" +
                            "},\n" +
                            "\"Elemental DPS\": 26,\n" +
                            "\"Fire DPS\": 26,\n" +
                            "\"Attacks per Second\": \"1.2\",\n" +
                            "\"Fire Damage\": {\n" +
                            "\"avg\": 22,\n" +
                            "\"min\": 14,\n" +
                            "\"max\": 30\n" +
                            "},\n" +
                            "\"Total Damage\": {\n" +
                            "\"max\": 30,\n" +
                            "\"avg\": 22,\n" +
                            "\"min\": 14\n" +
                            "},\n" +
                            "\"Physical Damage\": \"75-180\",\n" +
                            "\"Elemental Damage\": {\n" +
                            "\"max\": 30,\n" +
                            "\"avg\": 22,\n" +
                            "\"min\": 14\n" +
                            "},\n" +
                            "\"Critical Strike Chance\": \"6.65\"\n" +
                            "}\n" +
                            "},\n" +
                            "\"info\": {\n" +
                            "\"fullName\": \"Maelstr?m Nock Decimation Bow\",\n" +
                            "\"typeLine\": \"Decimation Bow\",\n" +
                            "\"tokenized\": {\n" +
                            "\"fullName\": \"maelstr?m nock decimation bow\"\n" +
                            "},\n" +
                            "\"icon\": \"http://web.poecdn.com/image/Art/2DItems/Weapons/TwoHandWeapons/Bows/Bow8.png\",\n" +
                            "\"name\": \"Maelstr?m Nock\"\n" +
                            "},\n" +
                            "\"shop\": {\n" +
                            "\"verified\": \"YES\",\n" +
                            "\"saleType\": \"b/o\",\n" +
                            "\"price\": {\n" +
                            "\"Chaos Orb\": 14\n" +
                            "},\n" +
                            "\"sellerAccount\": \"InsaneWallaby\",\n" +
                            "\"updated\": 1472856063000,\n" +
                            "\"priceSource\": \"stashName\",\n" +
                            "\"lastCharacterName\": \"Fiona_Falconstrike\",\n" +
                            "\"modified\": 1472856063000,\n" +
                            "\"hasPrice\": true,\n" +
                            "\"defaultMessage\": \"@Fiona_Falconstrike I would like to buy your Maelstr?m Nock Decimation Bow listed for 14 Chaos Orb (League:Standard, Stash Tab:~b/o 14 chaos [x6,y4])\",\n" +
                            "\"currency\": \"Chaos Orb\",\n" +
                            "\"chaosEquiv\": 14,\n" +
                            "\"amount\": \"14\",\n" +
                            "\"stash\": {\n" +
                            "\"inventoryID\": \"Stash14\",\n" +
                            "\"yLocation\": \"4\",\n" +
                            "\"stashID\": \"33f31a6998fb90b69db7a39b3f09f78e119333051688c2321b2cc75f34f98982\",\n" +
                            "\"xLocation\": \"6\",\n" +
                            "\"stashName\": \"~b/o 14 chaos\"\n" +
                            "},\n" +
                            "\"added\": 1472856063000\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            ",\n" +
                            "{\n" +
                            "\"_index\": \"poe01\",\n" +
                            "\"_type\": \"item\",\n" +
                            "\"_id\": \"7d6fb01317fc70cf87a325a0e894c777cd6acd216e281660c001124470375648\",\n" +
                            "\"_score\": 1,\n" +
                            "\"_source\": {\n" +
                            "\"mods\": {\n" +
                            "\"Bow\": {\n" +
                            "\"implicit\": {\n" +
                            "\"#% increased Critical Strike Chance\": 38\n" +
                            "},\n" +
                            "\"explicit\": {\n" +
                            "\"+#% to Global Critical Strike Multiplier\": 37,\n" +
                            "\"+# to Accuracy Rating\": 290,\n" +
                            "\"#% increased Physical Damage\": 60,\n" +
                            "\"Adds # to # Cold Damage\": {\n" +
                            "\"min\": 1,\n" +
                            "\"max\": 3,\n" +
                            "\"avg\": 2\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            "},\n" +
                            "\"uuid\": \"7d6fb01317fc70cf87a325a0e894c777cd6acd216e281660c001124470375648\",\n" +
                            "\"sockets\": {\n" +
                            "\"allSocketsSorted\": \"GG\",\n" +
                            "\"sortedLinkGroup\": {\n" +
                            "\"0\": \"G\",\n" +
                            "\"1\": \"G\"\n" +
                            "},\n" +
                            "\"totalGreen\": 2,\n" +
                            "\"socketCount\": 2,\n" +
                            "\"allSockets\": \"G-G\",\n" +
                            "\"largestLinkGroup\": 1,\n" +
                            "\"allSocketsGGG\": \"G G\"\n" +
                            "},\n" +
                            "\"modsTotal\": {\n" +
                            "\"+# to Accuracy Rating\": 290,\n" +
                            "\"Adds # to # Cold Damage\": {\n" +
                            "\"avg\": 2,\n" +
                            "\"min\": 1,\n" +
                            "\"max\": 3\n" +
                            "},\n" +
                            "\"#% increased Physical Damage\": 60,\n" +
                            "\"+#% to Global Critical Strike Multiplier\": 37,\n" +
                            "\"#% increased Critical Strike Chance\": 38\n" +
                            "},\n" +
                            "\"requirements\": {\n" +
                            "\"Level\": 68,\n" +
                            "\"Dex\": 212\n" +
                            "},\n" +
                            "\"shop\": {\n" +
                            "\"added\": 1472856065000,\n" +
                            "\"hasPrice\": false,\n" +
                            "\"sellerAccount\": \"Darkdexou\",\n" +
                            "\"updated\": 1472856065000,\n" +
                            "\"modified\": 1472856065000,\n" +
                            "\"verified\": \"YES\",\n" +
                            "\"stash\": {\n" +
                            "\"xLocation\": 0,\n" +
                            "\"stashID\": \"fb51258ccda420979e43c086791258c1aa2ddbb7f08196c40e63ee23a90f6c56\",\n" +
                            "\"inventoryID\": \"Stash16\",\n" +
                            "\"stashName\": \"Crafting\",\n" +
                            "\"yLocation\": 0\n" +
                            "},\n" +
                            "\"saleType\": \"Offer\",\n" +
                            "\"lastCharacterName\": \"SilentDec\"\n" +
                            "},\n" +
                            "\"info\": {\n" +
                            "\"name\": \"Phoenix Bane\",\n" +
                            "\"tokenized\": {\n" +
                            "\"fullName\": \"phoenix bane harbinger bow\"\n" +
                            "},\n" +
                            "\"typeLine\": \"Harbinger Bow\",\n" +
                            "\"fullName\": \"Phoenix Bane Harbinger Bow\"\n" +
                            "},\n" +
                            "\"properties\": {\n" +
                            "\"Weapon\": {\n" +
                            "\"Cold Damage\": {\n" +
                            "\"min\": 1,\n" +
                            "\"max\": 3,\n" +
                            "\"avg\": 2\n" +
                            "},\n" +
                            "\"Physical Damage\": \"56-146\",\n" +
                            "\"Critical Strike Chance\": \"6.9\",\n" +
                            "\"type\": {\n" +
                            "\"Bow\": true\n" +
                            "},\n" +
                            "\"Total DPS\": 2,\n" +
                            "\"Elemental Damage\": {\n" +
                            "\"avg\": 2,\n" +
                            "\"max\": 3,\n" +
                            "\"min\": 1\n" +
                            "},\n" +
                            "\"Elemental DPS\": 2,\n" +
                            "\"Attacks per Second\": \"1.2\",\n" +
                            "\"Total Damage\": {\n" +
                            "\"max\": 3,\n" +
                            "\"min\": 1,\n" +
                            "\"avg\": 2\n" +
                            "},\n" +
                            "\"Cold DPS\": 2\n" +
                            "}\n" +
                            "},\n" +
                            "\"attributes\": {\n" +
                            "\"lockedToCharacter\": false,\n" +
                            "\"explicitModsCount\": 4,\n" +
                            "\"mirrored\": false,\n" +
                            "\"equipType\": \"Bow\",\n" +
                            "\"baseItemName\": \"Harbinger Bow\",\n" +
                            "\"inventoryHeight\": 4,\n" +
                            "\"inventoryWidth\": 2,\n" +
                            "\"identified\": true,\n" +
                            "\"baseItemType\": \"Weapon\",\n" +
                            "\"ilvl\": 83,\n" +
                            "\"itemType\": \"Bow\",\n" +
                            "\"implicitModsCount\": 1,\n" +
                            "\"frameType\": 2,\n" +
                            "\"league\": \"Standard\",\n" +
                            "\"weaponType\": \"Bow\",\n" +
                            "\"corrupted\": false,\n" +
                            "\"rarity\": \"Rare\"\n" +
                            "}\n" +
                            "}\n" +
                            "}\n" +
                            "]\n" +
                            "}");

                    // Get hits JSON Array node

                    // TODO - Nico Helpppppppppppp
                    JSONArray contacts = jsonObj.getJSONArray("hits");

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);


                        JSONObject info = c.getJSONObject("info");
                        String fullName = info.getString("fullName");





                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("fullName", fullName);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(MainActivity.this, contactList,
                    R.layout.list_item, new String[]{ "fullName"},
                    new int[]{R.id.fullName});
            lv.setAdapter(adapter);
        }
    }
}
