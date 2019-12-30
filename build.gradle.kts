import net.mcparkour.migle.attributes.ApiVersion

plugins {
	java
	id("net.mcparkour.migle.migle-bukkit") version "1.1.1"
	id("com.github.johnrengelman.shadow") version "5.2.0"
}

java {
	sourceCompatibility = JavaVersion.VERSION_12
	targetCompatibility = JavaVersion.VERSION_12
}

repositories {
	jcenter()
	maven("https://papermc.io/repo/repository/maven-public") {
		content {
			includeGroup("com.destroystokyo.paper")
			includeGroup("net.md-5")
		}
	}
}

dependencies {
	implementation("net.mcparkour:common-math:1.0.3")
	implementation("net.mcparkour:common-text:1.0.3")
	compileOnly("com.destroystokyo.paper:paper-api:1.15.1-R0.1-SNAPSHOT")
	compileOnly("org.jetbrains:annotations:18.0.0")
}

migleBukkit {
	main = "com.thevoxelbox.voxelsniper.VoxelSniperPlugin"
	name = "VoxelSniper"
	apiVersion = ApiVersion.VERSION_1_15
	authors = listOf("przerwap", "MikeMatrix", "Gavjenks", "giltwist", "psanker", "Deamon5550", "DivineRage", "pitcer", "jaqobb")
	website = "https://github.com/mcparkournet/voxel-sniper-flattened"
	softDepend = listOf("VoxelModPackPlugin")
}
