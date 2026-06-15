# Generate Exam Reports
# Run this AFTER docker-compose up -d

# 1. Get PHP Modules
echo "Generating php-modules.txt..."
docker exec terrain-rental-web-1 php -m > php-modules.txt

# 2. Get MySQL Tables
echo "Generating mysql-tables.txt..."
docker exec terrain-rental-db-1 sh -c 'echo "show tables;" | mysql -u root -pHello@123 Sek_Thorn-db' > mysql-tables.txt

echo "Done. Please commit and push these files."
