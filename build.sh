#!/bin/bash

# Mindustry Mod Build Script for Endogenesis
# This script packages the mod into a .zip file ready for distribution

set -e  # Exit on error

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Get mod info from mod.json
MOD_NAME=$(grep -o '"name": *"[^"]*"' mod.json | sed 's/"name": *"\([^"]*\)"/\1/')
MOD_VERSION=$(grep -o '"version": *"[^"]*"' mod.json | sed 's/"version": *"\([^"]*\)"/\1/')

echo -e "${GREEN}Building Mindustry Mod: ${MOD_NAME} v${MOD_VERSION}${NC}"
echo "=========================================="

# Create build directory
BUILD_DIR="build"
OUTPUT_NAME="${MOD_NAME}-${MOD_VERSION}.zip"

echo -e "${YELLOW}Cleaning previous build...${NC}"
rm -rf "$BUILD_DIR"
mkdir -p "$BUILD_DIR"

echo -e "${YELLOW}Packaging mod files...${NC}"

# Create the mod zip file
# Include all necessary directories and files
zip -r "$BUILD_DIR/$OUTPUT_NAME" \
    mod.json \
    icon.png \
    bundles/ \
    content/ \
    maps/ \
    scripts/ \
    sounds/ \
    sprites/ \
    -x "*.git*" \
    -x "*/.DS_Store" \
    -x "*/Thumbs.db" \
    -x "*build.sh" \
    -x "*/build/*" \
    -x "*.md" \
    -x "*.txt" \
    -x "LICENSE"

if [ $? -eq 0 ]; then
    FILE_SIZE=$(du -h "$BUILD_DIR/$OUTPUT_NAME" | cut -f1)
    echo ""
    echo -e "${GREEN}✓ Build successful!${NC}"
    echo -e "Output: ${GREEN}$BUILD_DIR/$OUTPUT_NAME${NC} (${FILE_SIZE})"
    echo ""
    echo "To install:"
    echo "  1. Copy $OUTPUT_NAME to your Mindustry mods folder"
    echo "  2. Or share it for others to download"
else
    echo -e "${RED}✗ Build failed!${NC}"
    exit 1
fi
