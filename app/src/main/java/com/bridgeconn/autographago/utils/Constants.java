package com.bridgeconn.autographago.utils;

import com.bridgeconn.autographago.R;
import com.bridgeconn.autographago.models.AllBooksModel;

public class Constants {

    public static final String TAG = "AutographaGo";
    public static final String DUMMY_TAG = "abcd";

    public static final String API_BASE_URL = "https://raw.githubusercontent.com/friendsofagape/Autographa_Repo/master/Bibles/";
    public static final String META_DATA_FILE_NAME = "package.json";
    public static final String USFM_ZIP_FILE_NAME = "Archive.zip";
    public static final String APPEND_URL_FILE = "English/ULB/01-GEN.usfm";

    public static final String STORAGE_DIRECTORY = "/appname-external-data-cache/";

    public interface VersionNames {
        String UDB = "Unlocked Dynamic Bible";
        String ULB = "Unlocked Literal Bible";
    }

    public interface VersionCodes {
        String UDB = "UDB";
        String ULB = "ULB";
    }

    public interface Markers {
        String MARKER_BOOK_NAME = "\\id";
        String MARKER_CHAPTER_NUMBER = "\\c";
        String MARKER_VERSE_NUMBER = "\\v";
        String MARKER_NEW_PARAGRAPH = "\\p";
        String MARKER_SECTION_HEADING = "\\s";
        String MARKER_SECTION_HEADING_ONE = "\\s1";
        String MARKER_SECTION_HEADING_TWO = "\\s2";
        String MARKER_SECTION_HEADING_THREE = "\\s3";
        String MARKER_SECTION_HEADING_FOUR = "\\s4";
        String MARKER_CHUNK = "\\s5";
    }

    public interface Styling {
        String SPLIT_SPACE = "\\s+";
        String NEW_LINE = "\n";
        String NEW_LINE_WITH_TAB_SPACE = "\n    ";
        String MARKER_Q = "\\q";
        String REGEX_NUMBERS = "[^0-9]";
        String TAB_SPACE = "    ";
        String REGEX_ESCAPE = "\\";
        String CHAR_COLON = ":";
    }

    public static final String SHARE_TEXT_TYPE = "text/plain";

    public static final AllBooksModel CONTAINER = new AllBooksModel();

    public enum ParagraphMarker implements Comparable<ParagraphMarker> {
        V, P, S5, S4, S3, S2, S1;
    }

    public interface Tabs {
        String BOOK = "BOOK";
        String CHAPTER = "CHAPTER";
        String VERSE = "VERSE";
    }

    public interface TextEditor {
        String BOLD = "BOLD";
        String ITALICS = "ITALICS";
        String UNDERLINE = "UNDERLINE";
    }

    public interface USFMFiles {
        String HOSEA = "28-HOS.usfm";
        String _3_JOHN = "65-3JN.usfm";
        String ZEPHANIAH = "36-ZEP.usfm";
    }

    public interface MarkerTypes {
        String SECTION_HEADING_ONE = "s1";
        String SECTION_HEADING_TWO = "s2";
        String SECTION_HEADING_THREE = "s3";
        String SECTION_HEADING_FOUR = "s4";
        String CHUNK = "s5";
        String PARAGRAPH = "p";
        String VERSE = "v";
    }

    public interface Keys {
        String POSITION = "position";
        String TAB_NAME = "tabName";
        String BOOK_ID = "bookId";
        String SCREEN_MODE = "screenMode";
        String CHAPTER_NO = "chapter_number";
        String VERSE_NO = "verse_number";
        String VERSE_MODELS = "verse_models";
        String VERSE_SET = "verse_set";
        String SELECT_VERSE_FOR_NOTE = "select_verse_for_note";
        String OPEN_BOOK = "open_book";
        String VERSE_NOTE_MODEL = "verse_note_model";
        String SAVED_NOTE_TIMESTAMP = "saved_note_timestamp";
        String NOTES_MODEL = "notes_model";

        String READING_MODE_CHANGE = "reading_mode_change";
        String TEXT_SIZE_CHANGED = "text_size_changed";

        String LANGUAGE = "language";
        String VERSION = "version";
        String VERSION_NAME = "version_name";
    }

    public interface RequestCodes {
        int EDIT_NOTES = 0;
        int SETTINGS = 1;
        int PERMISSION_STORAGE = 2;
        int APP_SETTINGS_STORAGE = 3;
    }

    public interface PrefKeys {
        String LAST_READ_BOOK_ID = "last_read_book";
        String LAST_READ_CHAPTER = "last_read_chapter";
        String LAST_READ_VERSE = "last_read_verse";

        String FONT_SIZE = "font_size";
        String READING_MODE = "reading_mode";
    }

    public enum ReadingMode {
        Day(0, "Day"),
        Night(1, "Night");

        private int value;
        private String title;

        public int getValue() {
            return value;
        }

        public String getTitle() {
            return title;
        }

        ReadingMode(int value, String title) {
            this.value = value;
            this.title = title;
        }
    }

    public enum FontSize {
        XSmall(R.style.FontSize_XSmall, "XSmall"),
        Small(R.style.FontSize_Small, "Small"),
        Medium(R.style.FontSize_Medium, "Medium"),
        Large(R.style.FontSize_Large, "Large"),
        XLarge(R.style.FontSize_XLarge, "XLarge");

        private int resId;
        private String title;

        public int getResId() {
            return resId;
        }

        public String getTitle() {
            return title;
        }

        FontSize(int resId, String title) {
            this.resId = resId;
            this.title = title;
        }
    }
}