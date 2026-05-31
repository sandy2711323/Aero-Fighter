#!/bin/sh

# Aero Fighter - Greenfoot Game Runner for Linux / macOS
# Keep this script in the same folder as "Aero Fighter.jar"

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$SCRIPT_DIR" || exit 1

JAR_FILE="Aero Fighter.jar"

echo "Starting Aero Fighter..."
echo

# Check JAR exists
if [ ! -f "$JAR_FILE" ]; then
    echo "ERROR: $JAR_FILE not found."
    echo "Make sure this script is in the same folder as $JAR_FILE."
    exit 1
fi

# Check Java installed
if ! command -v java >/dev/null 2>&1; then
    echo "ERROR: Java is not installed or not available in PATH."
    echo "Please install Java 8, then run this script again."
    exit 1
fi

echo "Java found:"
java -version
echo

# Detect Java version
JAVA_VERSION="$(java -version 2>&1 | awk -F '"' '/version/ {print $2}')"

case "$JAVA_VERSION" in
    1.8.*)
        echo "Java 8 detected. Good."
        ;;
    *)
        echo "WARNING: This Greenfoot game may require Java 8 with JavaFX."
        echo "Your current Java version is: $JAVA_VERSION"
        echo "If the game fails, install/use Java 8."
        echo
        ;;
esac

# Run game
java -jar "$JAR_FILE"

echo
echo "Aero Fighter closed."