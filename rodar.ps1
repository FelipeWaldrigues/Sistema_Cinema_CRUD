# Compila e abre o menu do Sistema Cinema, lendo as credenciais do banco do arquivo .env
Set-Location $PSScriptRoot

Get-Content '.env' | ForEach-Object {
    if ($_ -match '^\s*([^#=]+?)\s*=\s*(.*)$') {
        [Environment]::SetEnvironmentVariable($matches[1], $matches[2], 'Process')
    }
}

# Console em UTF-8 para os acentos aparecerem certos
chcp 65001 > $null
[Console]::OutputEncoding = [Text.Encoding]::UTF8
[Console]::InputEncoding = [Text.Encoding]::UTF8


$fontes = Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName }
javac -encoding UTF-8 -d out -cp 'lib/*' $fontes
if ($LASTEXITCODE -ne 0) { exit 1 }

java '-Dstdout.encoding=UTF-8' -cp 'out;lib/*' app.Main
