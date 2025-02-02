## Overview
**MovieManiac** is your ultimate movie companion, providing an easy-to-use mobile platform to discover, explore, and dive into the world of movies. Powered by **The Movie Database (TMDb) API**, the app offers a seamless experience for movie enthusiasts looking for detailed information about movies, ratings, and much more.

## Requirements

Before building this project, make sure you have the following installed:

- **Android Studio Ladybug (2024.2.1 Patch 3)**: The latest stable version for Android development.
- **Java Development Kit (JDK)**: JDK 11 or higher recommended.

## Versions

- **Android Gradle Plugin (AGP)**: `8.7.3`
- **Kotlin**: `2.0.0`
- **Gradle**: `8.9`

## Getting Started

### Clone the repository

Clone this repository to your local machine using the following command:

```bash
git clone https://github.com/ujszaszik/movie-maniac.git
```

## API Key Setup

To use this application, you will need a **TMDb API key** to access movie data.

### Steps to Set Up the API Key:

1. **Find the API Key Placeholder**:
   - In the project, there is a placeholder text `"insert-your-api-key"` located in the `gradle.properties` file, under the key "apiKey"

2. **Insert Your Own API Key**:
   - Open local `gradle.properties` and replace the `"insert-your-api-key"` text with your own **TMDb API key**
   - Open global `gradle.properties`and override the `apiKey` text with your own **TMDb API key**:
   
   ```properties
   apiKey=[insert-your-api-key-here]

3. **Need an API Key?:**
If you don’t have an API key, feel free to ask me, and I’ll send you one!

## Architecture
The app follows an MVVM-based Android Clean Architecture, which can be represented by the following diagram:

<img width="556" alt="Képernyőfotó 2025-02-02 - 15 01 19" src="https://github.com/user-attachments/assets/6798d232-1564-4ccd-bbb8-950196ae39f4" />


## **Libraries Used**

### **1. Hilt - Dependency Injection**
- **Purpose**: Provides a simplified and efficient way to manage dependencies in the project, reducing boilerplate and improving readability.

### **2. Ktor - Network Client (with Ktor Serialization)**
- **Purpose**: Used for making HTTP requests to remote APIs and handling serialization of responses into Kotlin objects.

### **3. Room - For Local Data Cache**
- **Purpose**: A database library used for persisting data locally in SQLite, enabling offline capabilities and caching.

### **4. Paging3 - For Paging Data Requests**
- **Purpose**: Efficiently loads large datasets in chunks (pagination) to improve performance and user experience when displaying lists of items.

### **5. Coil - For Remote Images**
- **Purpose**: A powerful and easy-to-use image loading library for displaying images from remote sources, optimized for performance.
