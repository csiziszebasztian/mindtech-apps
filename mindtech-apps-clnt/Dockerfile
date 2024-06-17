# Stage 1: Build Stage
FROM node:20-alpine AS builder

# Install pnpm
RUN npm install -g pnpm

# Create and change to the app directory
WORKDIR /app

# Copy the package.json and pnpm-lock.yaml files
COPY package.json pnpm-lock.yaml ./

# Install dependencies
RUN pnpm install

# Copy the rest of the application code
COPY . .

# Build the Next.js application
RUN pnpm run build

# Stage 2: Production Stage
FROM node:20-alpine

# Create and change to the app directory
WORKDIR /app

# Copy only the necessary files from the builder stage
COPY --from=builder /app/package.json /app/pnpm-lock.yaml /app/
COPY --from=builder /app/.next /app/.next
COPY --from=builder /app/public /app/public

# Install pnpm and production dependencies only
RUN npm install -g pnpm && pnpm install --prod

# Expose the port the app runs on
EXPOSE 3000

# Start the Next.js application
CMD ["pnpm", "start"]