package me.gboom.uniShieldPatterns;

import org.bukkit.block.banner.PatternType;

//  I think this one is satisfying to look at.
public enum ShieldPatternsEnum {
    SQUARE_BOTTOM_LEFT("SBL", PatternType.SQUARE_BOTTOM_LEFT),
    SQUARE_BOTTOM_RIGHT("SBR", PatternType.SQUARE_BOTTOM_RIGHT),
    SQUARE_TOP_LEFT("STL", PatternType.SQUARE_TOP_LEFT),
    SQUARE_TOP_RIGHT("STR", PatternType.SQUARE_TOP_RIGHT),
    STRIPE_BOTTOM("STB", PatternType.STRIPE_BOTTOM),
    STRIPE_TOP("STT", PatternType.STRIPE_TOP),
    STRIPE_LEFT("SLE", PatternType.STRIPE_LEFT),
    STRIPE_RIGHT("SRI", PatternType.STRIPE_RIGHT),
    STRIPE_CENTER("STC", PatternType.STRIPE_CENTER),
    STRIPE_MIDDLE("STM", PatternType.STRIPE_MIDDLE),
    STRIPE_DOWNRIGHT("SDR", PatternType.STRIPE_DOWNRIGHT),
    STRIPE_DOWNLEFT("SDL", PatternType.STRIPE_DOWNLEFT),
    SMALL_STRIPES("SMS", PatternType.SMALL_STRIPES),
    CROSS("CRO", PatternType.CROSS),
    STRAIGHT_CROSS("SCR", PatternType.STRAIGHT_CROSS),
    TRIANGLE_BOTTOM("TRB", PatternType.TRIANGLE_BOTTOM),
    TRIANGLE_TOP("TRT", PatternType.TRIANGLE_TOP),
    TRIANGLES_BOTTOM("TSB", PatternType.TRIANGLES_BOTTOM),
    TRIANGLES_TOP("TST", PatternType.TRIANGLES_TOP),
    DIAGONAL_LEFT("DIL", PatternType.DIAGONAL_LEFT),
    DIAGONAL_UP_LEFT("DUL", PatternType.DIAGONAL_UP_LEFT),
    DIAGONAL_RIGHT("DIR", PatternType.DIAGONAL_RIGHT),
    CIRCLE("CIR", PatternType.CIRCLE),
    RHOMBUS("RHO", PatternType.RHOMBUS),
    HALF_VERTICAL("HAV", PatternType.HALF_VERTICAL),
    HALF_HORIZONTAL("HAH", PatternType.HALF_HORIZONTAL),
    HALF_VERTICAL_RIGHT("HVR", PatternType.HALF_VERTICAL_RIGHT),
    HALF_HORIZONTAL_BOTTOM("HHB", PatternType.HALF_HORIZONTAL_BOTTOM),
    BORDER("BOR", PatternType.BORDER),
    GRADIENT("GRA", PatternType.GRADIENT),
    GRADIENT_UP("GRU", PatternType.GRADIENT_UP),
    BRICKS("BRS", PatternType.BRICKS),
    CURLY_BORDER("CUB", PatternType.CURLY_BORDER),
    FLOWER("FLR", PatternType.FLOWER),
    CREEPER("CRE", PatternType.CREEPER),
    SKULL("SKU", PatternType.SKULL),
    MOJANG("MOJ", PatternType.MOJANG),
    GLOBE("GLO", PatternType.GLOBE),
    PIGLIN("PIG", PatternType.PIGLIN),
    FLOW("FLO", PatternType.FLOW),
    GUSTER("GUS", PatternType.GUSTER);

    final String code;
    final PatternType patternType;

    ShieldPatternsEnum(String code, PatternType patternType) {
        this.code = code;
        this.patternType = patternType;
    }
    public PatternType getPatternType() {
        return this.patternType;
    }
    public static ShieldPatternsEnum fromCode(String code) {
        for (ShieldPatternsEnum pattern : ShieldPatternsEnum.values()) {
            if (pattern.code.equalsIgnoreCase(code)) {
                return pattern;
            }
        }
        throw new IllegalArgumentException("Unknown pattern code: " + code);
    }
}
