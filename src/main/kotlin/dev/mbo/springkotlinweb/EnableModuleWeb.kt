package dev.mbo.springkotlinweb

import org.springframework.context.annotation.Import

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(ModuleWebConfig::class)
annotation class EnableModuleWeb
