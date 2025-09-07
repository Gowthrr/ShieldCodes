package me.gboom.uniShieldPatterns;

import org.bukkit.DyeColor;

//  There's probably a better way to do this because Spigot already has an enum, we just wanted to give it a value.
public enum DyesEnum {
    WHITE((byte) 0),
    LIGHT_GRAY((byte) 1),
    GRAY((byte) 2),
    BLACK((byte) 3),
    BROWN((byte) 4),
    RED((byte) 5),
    ORANGE((byte) 6),
    YELLOW((byte) 7),
    LIME((byte) 8),
    GREEN((byte) 9),
    CYAN((byte) 10),
    BLUE((byte) 11),
    PURPLE((byte) 12),
    MAGENTA((byte) 13),
    PINK((byte) 14);

    final Byte num; //  Memory status: Happy!

    DyesEnum(Byte num) {
        this.num = num;
    }
    public DyeColor toDyeColor() {
        return switch (this) {
            case WHITE -> DyeColor.WHITE;
            case LIGHT_GRAY -> DyeColor.LIGHT_GRAY;
            case GRAY -> DyeColor.GRAY;
            case BLACK -> DyeColor.BLACK;
            case BROWN -> DyeColor.BROWN;
            case RED -> DyeColor.RED;
            case ORANGE -> DyeColor.ORANGE;
            case YELLOW -> DyeColor.YELLOW;
            case LIME -> DyeColor.LIME;
            case GREEN -> DyeColor.GREEN;
            case CYAN -> DyeColor.CYAN;
            case BLUE -> DyeColor.BLUE;
            case PURPLE -> DyeColor.PURPLE;
            case MAGENTA -> DyeColor.MAGENTA;
            case PINK -> DyeColor.PINK;
        };
    }
    public static DyeColor fromByte(byte byteValue) {
        for (DyesEnum dye : DyesEnum.values()) {
            if (dye.num == byteValue) {
                return dye.toDyeColor();
            }
        }
        throw new IllegalArgumentException("Unknown byte"); // Stupid.
    }
}
