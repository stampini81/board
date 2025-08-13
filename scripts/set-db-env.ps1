# Sets DB environment variables for current PowerShell session
param(
  [string]$DbUrl = "jdbc:mysql://localhost:3306/board?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
  [string]$DbUser = "board",
  [string]$DbPassword = "board"
)

$env:DB_URL = $DbUrl
$env:DB_USER = $DbUser
$env:DB_PASSWORD = $DbPassword

Write-Host "Environment variables set:" -ForegroundColor Green
Write-Host "DB_URL=$env:DB_URL"
Write-Host "DB_USER=$env:DB_USER"
Write-Host "DB_PASSWORD=(hidden)"
