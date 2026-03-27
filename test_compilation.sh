gradle assembleDebug > log.txt 2>&1
if grep -q "BUILD SUCCESSFUL" log.txt; then
    echo "Compilation successful"
else
    echo "Compilation failed, first 50 lines of log:"
    head -n 50 log.txt
    echo "Errors:"
    grep -E "e: file" log.txt
fi
