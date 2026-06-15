# Use JDK 23 as base image
FROM openjdk:23-jdk-slim

# Install NGINX, SSH, and other dependencies
RUN apt-get update && apt-get install -y \
    nginx \
    openssh-server \
    git \
    maven \
    curl \
    php-cli \
    && rm -rf /var/lib/apt/lists/*

# Configure SSH
RUN mkdir /var/run/sshd
RUN echo 'root:Hello@123' | chpasswd
RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config

# Configure NGINX
COPY nginx.conf /etc/nginx/sites-available/default

# Set working directory
WORKDIR /app

# Clone the project (Placeholder URL - replace with actual if known)
# For this exam, we assume the code will be copied or cloned.
# Since the workspace is empty, I'll provide a way to handle it.
# RUN git clone https://github.com/your-repo/terrain-rental.git .

# Expose ports
EXPOSE 80 8080 22

# Start script to run all services
RUN echo "#!/bin/bash\n\
service ssh start\n\
service nginx start\n\
cd /app/terrain-rental && mvn spring-boot:run\n\
" > /start.sh && chmod +x /start.sh

CMD ["/start.sh"]
