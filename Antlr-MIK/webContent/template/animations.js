function getSelected() {
    var sel = document.getElementById('selector');
    var opt;
    for (var i = 0, len = sel.options.length; i < len; i++) {
        opt = sel.options[i];
        if (opt.selected === true) {
            break;
        }
    }
    return opt.value;
}

FUNCTIONTAG

ANIMATIONSLISTTAG

function playAllAnimations() {
    for (const key in animationsList) {
        animationsList[key].play();
    }
}

function resetAllAnimations() {
    for (const key in animationsList) {
        animationsList[key].reset();
    }
}

function pauseAllAnimations() {
    for (const key in animationsList) {
        animationsList[key].pause();
    }
}

function playSelectedAnimation() {
    if (getSelected() === "Simultaneously") {
        playAllAnimations();
    } else {
        getSelectedGamePiece().play();
    }
}

function restartSelectedAnimation() {
    if (getSelected() === "Simultaneously") {
        resetAllAnimations();
        playAllAnimations();
    } else {
        getSelectedGamePiece().restart();
    }
}

function getSelectedGamePiece() {
    return animationsList[getSelected()];
}

function resetSelectedAnimation() {
    if (getSelected() === "Simultaneously") {
        resetAllAnimations();
    } else {
        getSelectedGamePiece().reset();
    }
}

function pauseSelectedPiece() {
    if (getSelected() === "Simultaneously") {
        pauseAllAnimations();
    } else {
        getSelectedGamePiece().pause();
    }
}

document.querySelector('.play-btn').onclick = playSelectedAnimation;
document.querySelector('.pause-btn').onclick = pauseSelectedPiece;
document.querySelector('.restart-btn').onclick = restartSelectedAnimation;
document.querySelector('.reset-btn').onclick = resetSelectedAnimation;