# Java Conversion Documentation

## Overview

This mod has been successfully converted from JavaScript (old standard) to Java (new standard) for better performance, maintainability, and compatibility with modern Mindustry versions.

## Changes Made

### 1. Project Structure

**New Files:**
- `src/exogenesis/ExogenesisMod.java` - Main mod class
- `src/exogenesis/ExoUnits.java` - Unit AI and behavior handling
- `build.gradle` - Gradle build configuration
- `settings.gradle` - Gradle project settings

**Modified:**
- `mod.json` - Updated with Java configuration
- `.gitignore` - Added build artifacts

**Deprecated:**
- `scripts/` folder renamed to `scripts.old/` (JavaScript files no longer needed)

### 2. Code Conversion

#### JavaScript (Old):
```javascript
const ambassador = extendContent(UnitType, "drone-m", {});
ambassador.constructor = () => extend(UnitEntity, {});
ambassador.defaultController = () => extend(MinerAI, {});
```

#### Java (New):
```java
public class ExoUnits{
    private void setupMiningDrone(UnitType unit){
        unit.controller = u -> new MinerAI();
        unit.defaultController = MinerAI::new;
    }
}
```

### 3. mod.json Updates

- **version**: `1.9.1` → `2.0.0` (major version for Java rewrite)
- **minGameVersion**: `137` → `146` (updated to current Mindustry version)
- **Added**: `"main": "exogenesis.ExogenesisMod"` - Entry point
- **Added**: `"java": true` - Enables Java mod loading
- **Updated**: Description to reflect Java conversion

## Building the Mod

### Prerequisites
- Java JDK 8 or higher
- Gradle 7.6+ (or use the wrapper)
- Internet connection (for first build to download dependencies)

### Build Commands

```bash
# Build desktop JAR
gradle jar

# Build with deployment packaging
gradle deploy

# Build Android version (requires Android SDK)
gradle jarAndroid
```

### Output
- Desktop: `exogenesisDesktop.jar`
- Deployment: `exogenesis.jar`
- Android: `exogenesisAndroid.jar`

## Features

### Current Java Implementation

1. **ExogenesisMod.java**
   - Main mod entry point
   - Handles mod initialization
   - Shows welcome dialog on client load
   - Loads content through ExoUnits

2. **ExoUnits.java**
   - Manages unit AI and behavior
   - Configures mining drones (ambassador, backwater)
   - Sets up MinerAI for automated mining units
   - Configurable mining tier and speed

### Unit Types Converted

- **drone-m** (Ambassador) - Mining drone with MinerAI
- **drone-m2** (Backwater) - Mining drone with MinerAI

## Benefits of Java Conversion

1. **Performance** - Compiled Java code runs faster than interpreted JavaScript
2. **Type Safety** - Compile-time error checking prevents runtime issues
3. **IDE Support** - Better autocomplete, refactoring, and debugging
4. **Maintainability** - Easier to extend and modify
5. **Compatibility** - Better support for modern Mindustry versions (v146+)
6. **Features** - Access to full Mindustry API without limitations

## Testing

To test the mod:

1. Build the mod: `gradle jar`
2. Copy `build/libs/exogenesisDesktop.jar` to your Mindustry mods folder
3. Launch Mindustry
4. Verify the mod loads in the mods menu
5. Test mining drones in-game

## Future Enhancements

The Java structure makes it easy to add:
- Custom AI behaviors
- Advanced unit abilities
- Performance optimizations
- Better error handling
- More complex game mechanics

## Troubleshooting

### Build Errors

**"Could not resolve dependencies"**
- Ensure you have internet connection
- Dependencies are downloaded from JitPack and Maven Central

**"Unsupported Java version"**
- Requires Java 8+ (targetCompatibility = 8)
- Check with: `java -version`

### Runtime Errors

**"Mod not loading"**
- Verify `mod.json` has correct `main` class path
- Check that JAR contains compiled .class files
- Look for errors in Mindustry logs

## Migration Notes

If you're updating from the JavaScript version:

1. Save files are compatible (same internal mod name)
2. All content (blocks, items, units) remain the same
3. Unit behaviors have been preserved
4. No gameplay changes, only technical improvements

## Credits

- **Original Mod**: AureusStratus
- **Revamp**: Rosnok & contributors
- **Java Conversion**: Automated migration to modern standard
- **Faction Lore**: Đuvent

## License

Same as original Exogenesis mod.
